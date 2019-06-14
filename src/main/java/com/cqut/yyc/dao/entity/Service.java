package com.cqut.yyc.dao.entity;

public class Service {
	private Integer svId;
	private String svType;
	private String svContent;
	private String svDate;
	
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Service(Integer svId, String svType, String svContent, String svDate) {
		super();
		this.svId = svId;
		this.svType = svType;
		this.svContent = svContent;
		this.svDate = svDate;
	}
	public Integer getSvId() {
		return svId;
	}
	public void setSvId(Integer svId) {
		this.svId = svId;
	}
	public String getSvType() {
		return svType;
	}
	public void setSvType(String svType) {
		this.svType = svType;
	}
	public String getSvContent() {
		return svContent;
	}
	public void setSvContent(String svContent) {
		this.svContent = svContent;
	}
	public String getSvDate() {
		return svDate;
	}
	public void setSvDate(String svDate) {
		this.svDate = svDate;
	}
	
}
