package com.cqut.yyc.service;

import com.cqut.yyc.dao.entity.Contact;
import com.cqut.yyc.result.Result;
import com.cqut.yyc.vo.ivo.ReqContactVo;
import com.cqut.yyc.vo.ivo.ReqCustomerVo;
import com.cqut.yyc.vo.ivo.ReqDataVo;

public interface IContactService {
	Result addContact(ReqDataVo<Contact> reqData);
	Result getContactByCusNo(ReqDataVo<ReqCustomerVo> reqData);
	Result deleteContact(ReqDataVo<ReqContactVo> reqData);
}
