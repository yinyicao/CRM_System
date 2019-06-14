package com.cqut.yyc.dao;

import java.util.List;
import java.util.Map;

import com.cqut.yyc.dao.entity.Service;
import com.cqut.yyc.vo.ivo.RespServiceAnalysisVo;

public interface IServiceMapper {
	Integer addService(Service service);
	List<RespServiceAnalysisVo> selectCustomerServiceAnalysis();
	List<Service> selectAllServiceWithPage(Map<String, Integer> map);
	Integer selectAllCount();
}
