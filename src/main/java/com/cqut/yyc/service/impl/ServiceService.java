package com.cqut.yyc.service.impl;


import java.util.List;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.cqut.yyc.dao.IServiceMapper;
import com.cqut.yyc.dao.entity.Service;
import com.cqut.yyc.result.Result;
import com.cqut.yyc.service.IServiceService;
import com.cqut.yyc.vo.ivo.ReqDataVo;
import com.cqut.yyc.vo.ivo.RespServiceAnalysisVo;
import com.cqut.yyc.vo.ivo.ReqPageVo;
import com.cqut.yyc.vo.ivo.ReqServiceVo;
import com.cqut.yyc.vo.ivo.RespPageVo;

@org.springframework.stereotype.Service("serviceService")
public class ServiceService implements IServiceService{
	@Autowired
	private IServiceMapper serviceMapper;
	@Override
	public Result addService(ReqDataVo<Service> reqData) {
		// TODO Auto-generated method stub
		String resStr = "";
		System.out.println(reqData);
		System.out.println(reqData.getData().get(0));
		
		//??? reqData.getData().get(0)直接这样取为啥取到的不是对象呢？
		Service service= JSON.parseObject(JSON.toJSONString(reqData.getData().get(0)),
				Service.class);
		Integer res = serviceMapper.addService(service);
		resStr = res >= 1 ?"添加成功！":"添加失败，请重试！";
		return new Result(resStr,res);
	}

	
	@Override
	public Result getCustomerServiceAnalysis() {
		List<RespServiceAnalysisVo> customerServiceAnalysis = serviceMapper.selectCustomerServiceAnalysis();
		return new Result("成功！",customerServiceAnalysis);
	}

	@Override
	public Result getAllServiceWithPage(ReqPageVo serPage) {
		// TODO Auto-generated method stub
		//处理分页信息
				Map<String,Integer> map = new LinkedHashMap<>();
				map.put("start", (serPage.getPage()-1)*serPage.getSize());
				map.put("size", serPage.getSize());
				//查询分页数据
				List<Service> services = serviceMapper.selectAllServiceWithPage(map);
				//查询数据总数
				Integer count = serviceMapper.selectAllCount();
				//处理返回数据
				List<ReqServiceVo> serVos = new ArrayList<>();
				services.forEach(ser->{serVos.add(new ReqServiceVo(ser.getSvId(), ser.getSvType(), ser.getSvContent(), ser.getSvDate()));});
				//封装分页数据和返回数据
				RespPageVo rpv = new RespPageVo(count,serVos);
				return new Result("查询成功", rpv);
	}

}
