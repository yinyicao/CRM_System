package com.cqut.yyc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.cqut.yyc.dao.ICustomerMapper;
import com.cqut.yyc.dao.entity.Customer;
import com.cqut.yyc.exception.ResultException;
import com.cqut.yyc.result.Result;
import com.cqut.yyc.service.ICustomerService;
import com.cqut.yyc.vo.ivo.ReqPageVo;
import com.cqut.yyc.vo.ivo.RespCustomerRegionVo;
import com.cqut.yyc.vo.ivo.RespCustomerType;
import com.cqut.yyc.vo.ivo.ReqCustomerVo;
import com.cqut.yyc.vo.ivo.ReqDataVo;
import com.cqut.yyc.vo.ivo.RespCustomerVo;
import com.cqut.yyc.vo.ivo.RespPageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("customerService")
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerMapper customerMapper;

	@Override
	public Result addCustomer(ReqCustomerVo customer) {
		// TODO Auto-generated method stub
		System.err.println("test");
		Customer cus = new Customer(customer.getCusNo(),customer.getCusName(),customer.getCusRegion(), customer.getCusAddr(),customer.getCusUrl(),
				customer.getCusLevel(), Integer.valueOf(customer.getScore()));
		customerMapper.addCustomer(cus);
		return new Result("成功！",new String("test"));
	}

	/**
	 * 
	 * Title: getAllCustomer 
	 * Description:  未分页的数据
	 * @return   
	 * @see com.cqut.yyc.service.ICustomerService#getAllCustomer()
	 */
	@Override
	public Result getAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> customers = customerMapper.selectAllCustomer();
		List<ReqCustomerVo> cusVos = new ArrayList<>();
		customers.forEach(cus -> {
			cusVos.add(new ReqCustomerVo(cus.getCusId(),cus.getCusNo(),cus.getCusName(),
					cus.getCusRegion(),cus.getCusAddr(),cus.getCusUrl(),
					cus.getCusLevel(),cus.getCusCredit()));
		});
		return new Result("查询成功", cusVos);
	}

	/**
	 * 
	 * Title: getAllCustomerWithPage 
	 * Description:  自定义获取分页数据
	 * @param cusPage
	 * @return   
	 * @see com.cqut.yyc.service.ICustomerService#getAllCustomerWithPage(com.cqut.yyc.vo.ivo.ReqPageVo)
	 */
	@Override
	public Result getAllCustomerWithPage(ReqPageVo cusPage) {
		// TODO Auto-generated method stub
		//处理分页信息
		Map<String,Integer> map = new LinkedHashMap<>();
		map.put("start", (cusPage.getPage()-1)*cusPage.getSize());
		map.put("size", cusPage.getSize());
		//查询分页数据
		List<Customer> customers = customerMapper.selectCustomerWithPage(map);
		//查询数据总数
		Integer count = customerMapper.selectAllCount();
		//处理返回数据
		List<RespCustomerVo> cusVos = new ArrayList<>();
		customers.forEach(cus -> {
			cusVos.add(new RespCustomerVo(cus.getCusId(),cus.getCusNo(),cus.getCusName(),
					cus.getCusRegion(),cus.getCusAddr(),cus.getCusUrl(),
					cus.getCusLevel(),cus.getCusCredit()));
		});
		//封装分页数据和返回数据
		RespPageVo rpv = new RespPageVo(count,cusVos);
		return new Result("查询成功", rpv);
	}

	/**
	 * 
	 * Title: getAllCustomer 
	 * Description:  使用pageHelper获取分页数据
	 * @param cusPage
	 * @return   
	 * @see com.cqut.yyc.service.ICustomerService#getAllCustomer(com.cqut.yyc.vo.ivo.ReqPageVo)
	 */
	@Override
	public Result getAllCustomer(ReqDataVo<ReqPageVo> reqDataVo) {
		System.out.println(reqDataVo);
		// TODO Auto-generated method stub
		 ReqPageVo cusPage = JSON.parseObject(JSON.toJSONString(reqDataVo.getData().get(0)),
				ReqPageVo.class);
		//使用 pageHelper 处理分页和数据
		PageHelper.startPage(cusPage.getPage(), cusPage.getSize());
		List<Customer> customers = customerMapper.selectAllCustomer();
		
		//使用 pageHelper 查询数据总数
		PageInfo<Customer> pageInfo =new PageInfo<Customer>(customers);
		Integer count = (int) pageInfo.getTotal();
		
		//处理返回的数据
		List<ReqCustomerVo> cusVos = new ArrayList<>();
		customers.forEach(cus -> {
			cusVos.add(new ReqCustomerVo(cus.getCusId(),cus.getCusNo(),cus.getCusName(),
					cus.getCusRegion(),cus.getCusAddr(),cus.getCusUrl(),
					cus.getCusLevel(),cus.getCusCredit()));
		});
		//封装分页数据和返回数据
		RespPageVo rpv = new RespPageVo(count,cusVos);
		
		return new Result("查询成功", rpv);
	}

	@Override
	public Result deleteCustomer(ReqDataVo<ReqCustomerVo> reqDataVo) {
		// TODO Auto-generated method stub
		List<ReqCustomerVo> data = JSON.parseObject(JSON.toJSONString(reqDataVo.getData()), new TypeReference<List<ReqCustomerVo>>() {});
		Integer res = 0;
		try {
			for (ReqCustomerVo cus : data) {
				res += customerMapper.deleteCustomer(cus.getCusId());
			}
		} catch (Exception e) {
			System.err.println(e.getCause().getMessage());
			throw new ResultException("删除失败，请先删除该客户下的联系人！");
		}
		return new Result("删除成功", res);
	}

	@Override
	public Result updateCustomer(ReqCustomerVo customer) {
		System.out.println(customer);
		Customer cus = new Customer(customer.getCusId(),customer.getCusNo(),customer.getCusName(),customer.getCusRegion(), customer.getCusAddr(),customer.getCusUrl(),
				customer.getCusLevel(), Integer.valueOf(customer.getScore()));
		
		Integer res = customerMapper.updateCustomer(cus);
		return res >=1 ? new Result("修改成功！",res):new Result("修改失败！",res);
	}

	@Override
	public Result getCusNo() {
		List<Customer>  lis = customerMapper.selectAllCustomer();
		List<Map<String, String>> res = new ArrayList<>();
		lis.forEach(cus ->{
			Map<String, String> map= new HashMap<>();
			map.put("cusName", cus.getCusName());
			map.put("cusNo", cus.getCusNo());
			res.add(map);
		
		});
		return new Result("成功！",res);
	}

	@Override
	public Result getCustomerRegion() {
		List<RespCustomerRegionVo> customerRegion = customerMapper.selectCustomerRegion();
		return new Result("成功！",customerRegion);
	}
	
	@Override
	public Result getCustomerType() {
		List<RespCustomerType> customerLevel = customerMapper.selectCustomerType();
		return new Result("成功！",customerLevel);
	}

}
