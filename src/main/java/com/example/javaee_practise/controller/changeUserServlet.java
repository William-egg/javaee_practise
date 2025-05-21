package com.example.javaee_practise.controller;

import com.example.javaee_practise.Vo.changeUserInfo;
import com.example.javaee_practise.model.user;
import com.example.javaee_practise.service.userService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "changeUser", value = "/changeUserInfo")
public class changeUserServlet extends HttpServlet {
    userService userService = new userService();
    @Override
    public void init() {
        // Servlet初始化代码
        System.out.println("changeUserServlet initialized");
    }

    @Override
    public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        // 处理POST请求
        request.getParameterMap().forEach((key, value) -> System.out.println(key + ": " + String.join(", ", value)));
        System.out.println("changeUserServlet doPost method called");
        String username = request.getParameter("username");
        String newUsername = request.getParameter("newUsername");
        String newPassword = request.getParameter("newPassword");
        boolean ifSuccess = userService.changeUserByName(new changeUserInfo(username, newUsername, newPassword));
        if(ifSuccess){
            request.getSession().setAttribute("user",new user(newUsername,newPassword));
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"status\":success}");
        }else {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"status\":fail}");
        }
    }
    @Override
    public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        // 处理GET请求
        System.out.println("changeUserServlet doGet method called");
        response.setContentType("application/json;charset=UTF-8");
        System.out.println("logout: " + request.getParameter("logout"));
        if(request.getParameter("logout").equals("1")){
            request.getSession().invalidate(); // 使当前会话失效
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"status\":302}");
        }else {
            response.getWriter().write("{\"status\":success}");
        }
    }

}
