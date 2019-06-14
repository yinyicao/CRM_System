package com.cqut.yyc.service.impl;

import java.util.List;

import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqut.yyc.dao.IUserInfoMapper;
import com.cqut.yyc.dao.entity.UserInfo;
import com.cqut.yyc.service.IUserInfoService;
import com.cqut.yyc.shiro.RespShiroResult;
import com.cqut.yyc.shiro.ShiroResultEnum;
import com.cqut.yyc.vo.ivo.Login;

@Service("UserInfoService")
public class UserInfoService implements IUserInfoService {
	private final static Logger logger = LoggerFactory.getLogger(UserInfoService.class);
	
    @Autowired
    IUserInfoMapper userInfoMapper;
    @Override
    public UserInfo findByUsername(String username) {
        return userInfoMapper.findByUsername(username);
    }
	@Override
	public Object login(Login login) {
		String loginname = login.getLoginname().trim();
		String password = login.getPassword().trim();
		Boolean rememberme = login.getRememberme();
		String errmessage = "";
		List<String> roleNames = null;
		// 1、获取Subject实例对象
		Subject currentUser = SecurityUtils.getSubject();

		// 2、判断当前用户是否登录
		// if (currentUser.isAuthenticated() == false) {
		// 3、将用户名和密码,是否登记住我，封装到UsernamePasswordToken
		UsernamePasswordToken token = new UsernamePasswordToken(loginname, password,rememberme);
		// 4、认证
		try {
			currentUser.login(token);// 传到MyShiroRealm类中的方法进行认证
			Session session = currentUser.getSession();
			session.setAttribute("loginname", loginname);		
//			// 认证成功，返回角色信息
//			roleNames = roleRepository.findRoleName(loginname);
			session.setAttribute("role", roleNames);
			session.setTimeout(1000 * 60 * 60 * 2);//设置会话过期时间，2小时
			HashedMap data = new HashedMap();
			data.put("loginname", loginname);
			data.put("roleNames", roleNames);
			return new RespShiroResult(ShiroResultEnum.LOGIN_SUCCESS, data);
		} catch (UnknownAccountException uae) {
			logger.warn("对用户[" + loginname + "]进行登录验证..验证未通过,未知账户");
			errmessage = "未知账户";
		} catch (IncorrectCredentialsException ice) {
			logger.warn("对用户[" + loginname + "]进行登录验证..验证未通过,错误的凭证");
			errmessage = "密码不正确";
		} catch (LockedAccountException lae) {
			logger.warn("对用户[" + login + "]进行登录验证..验证未通过,账户已锁定");
			errmessage = "账户已锁定";
		} /*
			 * catch (PasswordNotModifyException pe) { logger.error("对用户[" +
			 * loginname + "]进行登录验证..验证未通过,堆栈轨迹如下"); pe.printStackTrace();
			 * errmessage = "修改密码后才允许登录！"; }
			 */ catch (AuthenticationException ae) {
			// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			logger.error("对用户[" + loginname + "]进行登录验证..验证未通过,堆栈轨迹如下");
			ae.printStackTrace();
			errmessage = "未知错误，请联系管理员！";
		}

		return new RespShiroResult(ShiroResultEnum.ERROR, errmessage,null);
	}
	
	@Override
	public RespShiroResult checkLogin() {
    	boolean isLogin = Boolean.FALSE;
    	Subject currentUser = SecurityUtils.getSubject();
    	isLogin =  currentUser.isAuthenticated();
    	return isLogin?
				new RespShiroResult(ShiroResultEnum.LOGINED):new RespShiroResult(ShiroResultEnum.UNLOGIN);
	}
	
	@Override
	public RespShiroResult logout() {
		return new RespShiroResult(ShiroResultEnum.LOGOUT_SUCCESS);
	}
}