package com.example.javaee_practise.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "test", value = "/test/test_1")
public class testServlet extends HttpServlet {
    @Override
    public void init() {
        // Servlet初始化代码
        System.out.println("testServlet initialized");
    }

    @Override
    public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
//        System.out.println(request.get);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("{\"status\":success}");
    }

}
