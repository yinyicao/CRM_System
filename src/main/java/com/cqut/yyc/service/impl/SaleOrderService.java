package com.cqut.yyc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqut.yyc.dao.ISaleOrderMapper;

import com.cqut.yyc.result.Result;
import com.cqut.yyc.service.ISaleOrderService;
import com.cqut.yyc.vo.ivo.ReqSaleOrderVo;
import com.cqut.yyc.dao.entity.SaleOrder;


@Service("saleorderService")
public class SaleOrderService implements ISaleOrderService {
	
	@Autowired
	private ISaleOrderMapper IsoMapper;
	
	@Override
	public Result addSaleOrder(ReqSaleOrderVo sale) {
		System.out.println(sale);
		SaleOrder so = new SaleOrder(sale.getSaleId(),sale.getSaleNo(),sale.getProName(),sale.getCusNo(),sale.getProPrice(),
				sale.getProNum(),sale.getProTotal(),sale.getProDate(),sale.getProState());
		IsoMapper.addSaleOrder(so);
		return new Result("成功！",new String("test"));
		
	}
}
