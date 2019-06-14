package com.cqut.yyc.vo.ivo;

public class RespCustomerVo   {
	private Integer cusId;
	private String cusNo;
	private String cusName;
	private String cusRegion;
	private String cusAddr;
	private String cusUrl;
	private String cusLevel;
	private Integer score;
	
	public RespCustomerVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RespCustomerVo(Integer cusId, String cusNo, String cusName, String cusRegion, String cusAddr, String cusUrl,
			String cusLevel, Integer score) {
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
	
	
}
