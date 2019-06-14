package com.cqut.yyc.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
 
/**
 * 跨域的设置问题
 */
@WebFilter(urlPatterns = "/*",filterName = "ACAFilter")
public class ACAFilter implements Filter {
	// 多个跨域域名设置
    public static final String[] ALLOW_DOMAIN = {
    		"http://127.0.01:8080",
            "http://localhost:8020", 
            "http://localhost:8080",
            "http://127.0.0.1:8020",
            "http://120.79.191.7:8080",
            "http://yinyicao.work:8080",
            "http://120.79.191.7:8888",
            "http://yinyicao.work:8888"};
    /**
     * 初始化
     * @param filterConfig FilterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
 
    /**
     * 过滤
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        String originHeader = req.getHeader("Origin");
        if (Arrays.asList(ALLOW_DOMAIN).contains(originHeader)) {
//          resp.setHeader("Access-Control-Allow-Origin", "*");
        	resp.setHeader("Access-Control-Allow-Origin", originHeader);
            resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
            resp.setHeader("Access-Control-Max-Age", "3600");
            resp.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type, Accept, Origin");
            resp.setHeader("Access-Control-Allow-Credentials", "true");

            
            //解决OPTIONS请求重定向错误 Response to preflight request doesn't pass access control check: 
            //Redirect is not allowed for a preflight request.
            if (req.getMethod().equals("OPTIONS")) {
            	resp.setStatus(200);
                return;
            }
            chain.doFilter(req, resp);

            System.out.println("to access control allow origin");
        }
    }
 
    /**
     * 销毁
     */
    @Override
    public void destroy() {
    }
}