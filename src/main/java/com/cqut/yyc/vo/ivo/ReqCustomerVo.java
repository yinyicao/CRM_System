package com.cqut.yyc.vo.ivo;

import com.cqut.yyc.vo.RequestMessageBase;

public class ReqCustomerVo extends RequestMessageBase {
	private Integer cusId;
	private String cusNo;
	private String cusName;
	private String cusRegion;
	private String cusAddr;
	private String cusUrl;
	private String cusLevel;
	private Integer score;

	public ReqCustomerVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReqCustomerVo(Integer cusId,String cusNo, String cusName, String cusRegion, String cusAddr, String cusUrl, String cusLevel,
			Integer score) {
		super();
		this.cusId = cusId;
		this.cusNo = cusNo;
		this.cusName = cusName;
		this.cusRegion = cusRegion;
		this.cusAddr = cusAddr;
		this.cusUrl = cusUrl;
		this.cusLevel = cusLevel;
		this.score = score;
	}
	

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public String getCusNo() {
		return cusNo;
	}
	public void setCusNo(String cusNo) {
		this.cusNo = cusNo;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusRegion() {
		return cusRegion;
	}
	public void setCusRegion(String cusRegion) {
		this.cusRegion = cusRegion;
	}
	public String getCusAddr() {
		return cusAddr;
	}
	public void setCusAddr(String cusAddr) {
		this.cusAddr = cusAddr;
	}
	public String getCusUrl() {
		return cusUrl;
	}
	public void setCusUrl(String cusUrl) {
		this.cusUrl = cusUrl;
	}
	public String getCusLevel() {
		return cusLevel;
	}
	public void setCusLevel(String cusLevel) {
		this.cusLevel = cusLevel;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "CustomerVo [id=" + id + ",cusId=" + cusId + ", cusNo=" + cusNo + ", cusName=" + cusName + ", cusRegion=" + cusRegion
				+ ", cusAddr=" + cusAddr + ", cusUrl=" + cusUrl + ", cusLevel=" + cusLevel + ", score=" + score + "]";
	}
	
}
