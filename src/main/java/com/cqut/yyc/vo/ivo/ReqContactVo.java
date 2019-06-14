package com.cqut.yyc.vo.ivo;

import com.cqut.yyc.vo.RequestMessageBase;

public class ReqContactVo extends RequestMessageBase {
	private Integer ctId;
	private String cusNo;
	private String ctName;
	private String ctTitle;
	private String ctGender;
	private String ctPhone;
	private String ctMemo;
	public Integer getCtId() {
		return ctId;
	}
	public void setCtId(Integer ctId) {
		this.ctId = ctId;
	}
	public String getCusNo() {
		return cusNo;
	}
	public void setCusNo(String cusNo) {
		this.cusNo = cusNo;
	}
	public String getCtName() {
		return ctName;
	}
	public void setCtName(String ctName) {
		this.ctName = ctName;
	}
	public String getCtTitle() {
		return ctTitle;
	}
	public void setCtTitle(String ctTitle) {
		this.ctTitle = ctTitle;
	}
	public String getCtGender() {
		return ctGender;
	}
	public void setCtGender(String ctGender) {
		this.ctGender = ctGender;
	}
	public String getCtPhone() {
		return ctPhone;
	}
	public void setCtPhone(String ctPhone) {
		this.ctPhone = ctPhone;
	}
	public String getCtMemo() {
		return ctMemo;
	}
	public void setCtMemo(String ctMemo) {
		this.ctMemo = ctMemo;
	}
	@Override
	public String toString() {
		return "ReqContactVo [ctId=" + ctId + ", cusNo=" + cusNo + ", ctName=" + ctName + ", ctTitle=" + ctTitle
				+ ", ctGender=" + ctGender + ", ctPhone=" + ctPhone + ", ctMemo=" + ctMemo + ", id=" + id + "]";
	}
	
}
