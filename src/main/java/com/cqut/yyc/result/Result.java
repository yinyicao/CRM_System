package com.cqut.yyc.result;

import java.io.Serializable;

/**
 * 
 * @ClassName:  Result   
 * @Description:TODO(结果集，用在业务逻辑返回)   
 * @author: yinyicao
 * @date:   2019年6月12日 下午7:12:27   
 *     
 * @Copyright: 2019 www.yinyicao.work. All rights reserved. 
 *
 */
public class Result implements Serializable{
	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;
	private Object code;
	private Object data;

	public Result() {
		super();
	}

	public Result(Object code, Object obj) {
		super();
		this.code = code;
		this.data = obj;
	}

	public Object getCode() {
		return code;
	}

	public void setCode(Object code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
