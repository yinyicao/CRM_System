package com.cqut.yyc.filter;
import com.alibaba.fastjson.JSONObject;
import com.cqut.yyc.shiro.RespShiroResult;
import com.cqut.yyc.shiro.ShiroResultEnum;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @ClassName:  ShiroLoginFilter   
 * @Description:TODO(登录认证过滤器，未登录则拦截并向前端发送json数据提示未登录
 * 不可以在shiro配置中设置shiroFilterFactoryBean.setLoginUrl("/nologin");
 * 因为这种setLoginUrl方式只能做后端跳转。
 * 在前后端分离情况下，前端会报302/301强制重定向警告。
 * )   
 * @author: yinyicao
 * @date:   2019年6月12日 下午4:12:16   
 *     
 * @Copyright: 2019 www.yinyicao.work. All rights reserved. 
 *
 */
public class ShiroLoginFilter extends FormAuthenticationFilter {

	/**
	 * 
	 * Title: isAccessAllowed 
	 * Description:   是否允许通过 ,覆写这个方法，可自定义鉴权
	 * @param request
	 * @param response
	 * @param mappedValue
	 * @return   true：允许.说明shiro鉴权通过，
	 * 			false: 不允许 执行redirectToLogin方法跳转到登录页面
	 * @see org.apache.shiro.web.filter.authc.AuthenticatingFilter#isAccessAllowed(javax.servlet.ServletRequest, javax.servlet.ServletResponse, java.lang.Object)
	 */
    @Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){
    	System.err.println("-----------------ShiroLoginFilter---isAccessAllowed-------------------");
//    	boolean isLogin = Boolean.FALSE;
//    	Subject currentUser = getSubject(request, response);
//    	isLogin =  currentUser.isAuthenticated();
//    	return isLogin;
        return super.isAccessAllowed(request, response, mappedValue);
    	
	}

	/**
            * 在访问controller（url）前判断是否登录，返回json。
     * @param request
     * @param response
     * @return true-继续往下执行，false-该filter过滤器已经处理，不继续执行其他过滤器
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
    	System.err.println("-----------------ShiroLoginFilter---onAccessDenied-------------------");
    	HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        RespShiroResult resultData = new RespShiroResult(ShiroResultEnum.UNLOGIN);
        httpServletResponse.getWriter().write(JSONObject.toJSON(resultData).toString());
        return false;
    }

}