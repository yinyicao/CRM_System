package com.cqut.yyc.dao.entity;

import java.sql.Date;

public class SaleOrder {
	private int saleId;
	private String saleNo;
	private String proName;
	private String cusNo;
	private double proPrice;
	private  int proNum;
	private double proTotal;
	private Date proDate;
	private String proState;
	

	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public String getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getCusNo() {
		return cusNo;
	}
	public void setCusNo(String cusName) {
		this.cusNo = cusName;
	}
	public double getProPrice() {
		return proPrice;
	}
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	public int getProNum() {
		return proNum;
	}
	public void setProNum(int proNum) {
		this.proNum = proNum;
	}
	public double getProTotal() {
		return proTotal;
	}
	public void setProTotal(double proTotal) {
		this.proTotal = proTotal;
	}
	public Date getProDate() {
		return proDate;
	}
	public void setProDate(Date proDate) {
		this.proDate = proDate;
	}
	public String getProState() {
		return proState;
	}
	public void setProState(String proState) {
		this.proState = proState;
	}
	public SaleOrder(int saleId, String saleNo, String proName, String cusNo, double proPrice, int proNum,
			double proTotal, Date proDate, String proState) {
		super();
		this.saleId = saleId;
		this.saleNo = saleNo;
		this.proName = proName;
		this.cusNo = cusNo;
		this.proPrice = proPrice;
		this.proNum = proNum;
		this.proTotal = proTotal;
		this.proDate = proDate;
		this.proState = proState;
	}
	@Override
	public String toString() {
		return "SaleOrder [saleId=" + saleId + ", saleNo=" + saleNo + ", proName=" + proName + ", cusNo=" + cusNo
				+ ", proPrice=" + proPrice + ", proNum=" + proNum + ", proTotal=" + proTotal + ", proDate=" + proDate
				+ ", proState=" + proState + "]";
	}
	
	

}
