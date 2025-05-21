package com.example.javaee_practise.filter;

import com.example.javaee_practise.model.user;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/index.html")
public class indexHtmlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String uri = httpRequest.getRequestURI();
        user user = (user) httpRequest.getSession().getAttribute("user");
        if (user == null) {
            // 如果没有登录，重定向到登录页面
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");
            return;
        }
        // 如果已登录，继续处理请求
        filterChain.doFilter(servletRequest, servletResponse);//这个地方要放行。
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
