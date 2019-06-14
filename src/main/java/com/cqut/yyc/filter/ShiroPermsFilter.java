package com.cqut.yyc.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import com.alibaba.fastjson.JSONObject;
import com.cqut.yyc.shiro.RespShiroResult;
import com.cqut.yyc.shiro.ShiroResultEnum;

/**
 * 
 * @ClassName:  ShiroPermsFilter   
 * @Description:TODO(和ShiroLoginFilter一样的作用，只是ShiroLoginFilter是
 * 登录认证，而ShiroPermsFilter是权限认证)   
 * @author: yinyicao
 * @date:   2019年6月12日 下午4:21:14   
 *     
 * @Copyright: 2019 www.yinyicao.work. All rights reserved. 
 *
 */
public class ShiroPermsFilter extends PermissionsAuthorizationFilter {
	
    /**
     * shiro认证perms资源失败后回调方法
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws IOException
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
    	System.err.println("-----------------ShiroPermsFilter---onAccessDenied-------------------");
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        RespShiroResult resultData = new RespShiroResult(ShiroResultEnum.UNAUTHORIZED);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(JSONObject.toJSONString(resultData));
        return false;
    }
}