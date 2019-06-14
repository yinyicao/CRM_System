package com.cqut.yyc.service;

import com.cqut.yyc.result.Result;
import com.cqut.yyc.vo.ivo.ReqPageVo;
import com.cqut.yyc.vo.ivo.ReqCustomerVo;
import com.cqut.yyc.vo.ivo.ReqDataVo;

public interface ICustomerService {

	 Result addCustomer(ReqCustomerVo customer);
	 Result getAllCustomer();
	 Result getAllCustomerWithPage(ReqPageVo cusPage);
	 Result getAllCustomer(ReqDataVo<ReqPageVo> reqDataVo);
	 Result deleteCustomer(ReqDataVo<ReqCustomerVo> reqDataVo);
	 Result updateCustomer(ReqCustomerVo customer);
	 Result getCusNo();
	 Result getCustomerRegion();
	 Result getCustomerType();
}
