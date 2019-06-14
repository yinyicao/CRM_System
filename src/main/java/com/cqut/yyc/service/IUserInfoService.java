package com.cqut.yyc.service;

import com.cqut.yyc.dao.entity.UserInfo;
import com.cqut.yyc.shiro.RespShiroResult;
import com.cqut.yyc.vo.ivo.Login;

public interface IUserInfoService {
    /**通过username查找用户信息;*/
    UserInfo findByUsername(String username);
	//登录
	Object login(Login login);
	
	RespShiroResult checkLogin();
	
	RespShiroResult logout();
}