package com.cqut.yyc.vo.ivo;

import com.cqut.yyc.vo.RequestMessageBase;

public class ReqPageVo  extends RequestMessageBase{
	private Integer page;
	private Integer size;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "ReqPageVo [page=" + page + ", size=" + size + "]";
	}
	
}
