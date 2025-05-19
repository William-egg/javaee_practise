package com.example.javaee_practise.controller;

import com.example.javaee_practise.utilts.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class loginServlet extends HttpServlet {
    @Override
    public void init() {
        // Servlet初始化代码
        System.out.println("LoginServlet initialized");
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理GET请求
        String username = (String) request.getSession().getAttribute("username");


    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理POST请求
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+"     "+ password);
        if(new jdbc().ifLogin(username,password)){//jdbc判断是否为真
            request.getSession().setAttribute("username", username);
            response.sendRedirect("/index.html");
            //接下来的逻辑就是转到index，然后展示所有用户跟本用户的所有信息了。
        }else{
            //jdbc判断用户不存在
            //返回弹窗用户不存在或者密码错误
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<script>alert('Login failed! Incorrect username or password.'); window.location.href='login.html';</script>");
//            response.sendRedirect("/login.html");
        }

        //转发
//        request.getRequestDispatcher("/").forward(request, response);
//            重定向
//        response.sendRedirect("/index.html");
    }
    }
