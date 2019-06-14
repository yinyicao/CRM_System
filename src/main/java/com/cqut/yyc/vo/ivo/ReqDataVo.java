package com.cqut.yyc.vo.ivo;

import java.util.List;

import com.cqut.yyc.vo.RequestMessageBase;

public class ReqDataVo<T> extends RequestMessageBase {
	private List<T> data;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ReqDataVo [data=" + data + ", id=" + id + "]";
	}
	
}
