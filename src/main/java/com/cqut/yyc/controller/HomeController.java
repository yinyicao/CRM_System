package com.cqut.yyc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cqut.yyc.service.IUserInfoService;
import com.cqut.yyc.vo.ivo.Login;

@RestController
//@CrossOrigin
public class HomeController {

	@Autowired
	private IUserInfoService userService;

	/**
	 * shiro认证，验证用户登录状态，调用该方法 。
	 */
	@RequestMapping(value = { "/checkLogin" })
	public Object checkLogin() {
		return userService.checkLogin();
	}


	/**
	 * 真正的登录方法
	 */
	@RequestMapping(value = "/login")
	public Object login(@RequestBody Login user) {

		return userService.login(user);
	}
	
	
//	@RequestMapping(value = "/logout")
//	public Object logout() {
//
//		return userService.logout();
//	}
}
