package com.cqut.yyc.vo.ivo;


/**
 * @ClassName:  RespPageVo   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: yinyicao
 * @date:   2019年5月31日 上午10:53:46   
datagrid前端组件需要的JSON数据有total和rows两个属性
total是表里的总记录数（使用pageHelper插件的话，就使用PageInfo对象的getTotal方法获取）
rows是当前页需要显示的数据列表
 * @Copyright: 2019 www.yinyicao.work. All rights reserved. 
 *
 */
public class RespPageVo  {
	private Integer total;
	private Object rows;

	
	public RespPageVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RespPageVo(Integer total, Object rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}
	
	
}
