package com.cqut.yyc.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import com.cqut.yyc.exception.ResultException;
import com.cqut.yyc.result.Result;
import com.cqut.yyc.vo.RequestMessageBase;
import com.cqut.yyc.vo.ResponseMessageBase;


public class MsgProcessor {

	private static ResponseMessageBase respMsg = new ResponseMessageBase();

	/**
	 * 
	 * @Title: process   
	 * @Description: TODO(处理请求消息)   
	 * @param: @param serviceName
	 * @param: @param methodName
	 * @param: @param strReqMsg
	 * @param: @param httpSession
	 * @param: @return      
	 * @return: ResponseMessageBase      
	 * @throws
	 */
	public static ResponseMessageBase process(String serviceName, String methodName, String strReqMsg,
			HttpSession httpSession) {
		// 通过Service名字获取bean
		Object objService = null;
		try {
			objService = SpringUtils.getBean(serviceName);
		} catch (Exception ex) {
		}

		// 未找到service
		if (objService == null) { 
			return abnormalReturns(respMsg, "服务" + serviceName + "未找到");
		}

		// 获取Service的方法
		Method method = null;
		try {
			method = getMethod(objService, methodName);
		} catch (Exception ex) {
		}

		// service中不存在对应方法
		if (method == null) { 
			return abnormalReturns(respMsg, serviceName + "中未找到方法" + methodName);
		}

		// 获取方法参数类型
		Class<?>[] paramTypes = method.getParameterTypes();


		// msg.data(json格式)转换为对象
		com.fasterxml.jackson.databind.ObjectMapper mapper = 
				new com.fasterxml.jackson.databind.ObjectMapper();
		RequestMessageBase reqMsg = null;
		if (paramTypes.length > 0) // 参数个数大于0时才解析msg.data
		{
			// 获得第一个参数的类型
			Class<?> paramType = paramTypes[0]; 
			try {
				// 将json格式字符串转换为对象（目标对象继承自RequestMessageBase）
				reqMsg = (RequestMessageBase) mapper.readValue(strReqMsg, paramType);

			} catch (Exception ex) {
				ex.printStackTrace();
				return abnormalReturns(respMsg, "JSON数据1\n" + strReqMsg + "\n转换为" + paramType.getName() + "失败");
			}
		}
		if (reqMsg != null) {
			// 要求前端每一个请求必须传一个id,在请求体为空的情况下且不判断空，会报错
			respMsg.id = reqMsg.id;
		} else {// 准备调用的方法的形参个数=0时，reqMsg在上面就没有实例化
			try {
				reqMsg = mapper.readValue(strReqMsg, RequestMessageBase.class);
			} catch (Exception e) {
				e.printStackTrace();
				return abnormalReturns(respMsg, "JSON数据2\n" + strReqMsg + "\n转换为" + RequestMessageBase.class + "失败");
			}
			respMsg.id = reqMsg.id;
		}
		try {
			Result result = null;

			if (paramTypes.length == 0)
				result = (Result) method.invoke(objService);
			else if (paramTypes.length == 1)
				result = (Result) method.invoke(objService, reqMsg);
			else if (paramTypes.length == 2) // 第二个参数为session（用于要获取session进行二次用户权限验证的方法）
				result = (Result) method.invoke(objService, reqMsg, httpSession);
			// resMsg.data = mapper.writeValueAsString(retObj);
			respMsg.data = result.getData();
			respMsg.status = 200;
			respMsg.desc = String.valueOf(result.getCode());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | ResultException ex) {
			respMsg.data = null;
			respMsg.status = 0;
			if (ex.getCause() != null) {
				respMsg.desc = ex.getCause().getMessage();
			} else {
				respMsg.desc = ex.getMessage();
			}
			ex.printStackTrace();
		}
		// 返回结果
		return respMsg;

	}

	private static Method getMethod(Object objService, String methodName) {
		Class<?> cls = objService.getClass();
		Method serviceMethod = null;
		Method[] ms = cls.getMethods();
		for (Method m : ms)
			if (m.getName().equals(methodName)) {
				serviceMethod = m;
				break;
			}
		return serviceMethod;
	}

	private static ResponseMessageBase abnormalReturns(ResponseMessageBase resMsg, String data) {
		System.out.println("------abnormalReturns------" + data);
		resMsg.status = 1;
		resMsg.data = data;
		return resMsg;
	}
	
}