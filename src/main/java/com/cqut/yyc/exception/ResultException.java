package com.cqut.yyc.exception;

/**
 * 
 * @ClassName:  ResultException   
 * @Description:TODO(自定义异常)   
 * @author: yinyicao
 * @date:   2019年5月30日 上午10:18:41   
 *     
 * @Copyright: 2019 www.yinyicao.work. All rights reserved. 
 *
 */
public class ResultException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String msg = null;

	public ResultException(String msg) {
		super(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
