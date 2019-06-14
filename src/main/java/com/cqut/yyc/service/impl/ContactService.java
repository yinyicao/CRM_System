package com.cqut.yyc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.cqut.yyc.dao.IContactMapper;
import com.cqut.yyc.dao.entity.Contact;
import com.cqut.yyc.result.Result;
import com.cqut.yyc.service.IContactService;
import com.cqut.yyc.vo.ivo.ReqContactVo;
import com.cqut.yyc.vo.ivo.ReqCustomerVo;
import com.cqut.yyc.vo.ivo.ReqDataVo;

@Service
public class ContactService implements IContactService{

	@Autowired
	private IContactMapper contactMapper;
	
	@Override
	public Result addContact(ReqDataVo<Contact> reqData) {
		String resStr = "";
		System.out.println(reqData);
		System.out.println(reqData.getData().get(0));
		
		//??? reqData.getData().get(0)直接这样取为啥取到的不是对象呢？
		Contact contact = JSON.parseObject(JSON.toJSONString(reqData.getData().get(0)),
				Contact.class);
		Integer res = contactMapper.addContact(contact);
		resStr = res >= 1 ?"添加成功！":"添加失败，请重试！";
		return new Result(resStr,res);
	}
	
	@Override
	public Result getContactByCusNo(ReqDataVo<ReqCustomerVo> reqData) {
		// TODO Auto-generated method stub
		Contact contact = JSON.parseObject(JSON.toJSONString(reqData.getData().get(0)),
				Contact.class);
		List<Contact> contacts = contactMapper.selectContactsByCusNo(contact.getCusNo());
		return new Result("查询成功！",contacts);
	}

	@Override
	public Result deleteContact(ReqDataVo<ReqContactVo> reqData) {
		List<ReqContactVo> data = JSON.parseObject(JSON.toJSONString(reqData.getData()), new TypeReference<List<ReqContactVo>>() {});
		Integer res = 0;
		for (ReqContactVo cont : data) {
			res += contactMapper.deleteContact(cont.getCtId());
		}
		return res >=1 ? new Result("删除成功！",res):new Result("删除失败！",res);
	}

}
