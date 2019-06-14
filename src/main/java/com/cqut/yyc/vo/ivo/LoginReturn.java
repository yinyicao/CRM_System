package com.cqut.yyc.vo.ivo;

import java.util.List;

/**
 * 
 * @author yyc
 *
 */
public class LoginReturn {
    
	private Integer code;
	private String loginname;// 登录名
	private List<String> roles;// 拥有的角色

	public LoginReturn() {
		super();
		// TODO Auto-generated constructor stub
	}



	public LoginReturn(Integer code, String loginname, List<String> roles) {
		super();
		this.code = code;
		this.loginname = loginname;
		this.roles = roles;
	}



	public Integer getCode() {
		return code;
	}



	public void setCode(Integer code) {
		this.code = code;
	}



	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}


	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}


}
