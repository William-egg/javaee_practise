package com.example.javaee_practise.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "logout", value = "/logout")
public class logoutServlet extends HttpServlet {
    @Override
    public void init() {
        // Servlet初始化代码
        System.out.println("LogoutServlet initialized");
    }
    @Override
    public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        // 处理GET请求
        System.out.println("LogoutServlet doGet method called");
        request.getSession().invalidate(); // 使当前会话失效
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("{\"status\":302}");
    }

}
