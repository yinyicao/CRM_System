package com.cqut.yyc.service;


import com.cqut.yyc.dao.entity.Service;
import com.cqut.yyc.result.Result;
import com.cqut.yyc.vo.ivo.ReqDataVo;
import com.cqut.yyc.vo.ivo.ReqPageVo;

public interface IServiceService {
	Result addService(ReqDataVo<Service> reqData);
	 Result getCustomerServiceAnalysis();
	Result getAllServiceWithPage(ReqPageVo serPage);
}
