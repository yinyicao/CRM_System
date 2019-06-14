package com.cqut.yyc.dao;

import java.util.List;
import java.util.Map;

import com.cqut.yyc.dao.entity.Customer;
import com.cqut.yyc.vo.ivo.RespCustomerRegionVo;
import com.cqut.yyc.vo.ivo.RespCustomerType;

public interface ICustomerMapper {
	void addCustomer(Customer cus);
	List<Customer> selectAllCustomer();
	List<Customer> selectCustomerWithPage(Map<String, Integer> map);
	Integer selectAllCount();
	Integer deleteCustomer(Integer cusId);
	Integer updateCustomer(Customer cus);
	List<RespCustomerRegionVo> selectCustomerRegion();
	List<RespCustomerType> selectCustomerType();
}
