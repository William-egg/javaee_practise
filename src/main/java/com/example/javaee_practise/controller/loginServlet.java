package com.example.javaee_practise.controller;

import com.example.javaee_practise.Dto.userDto;
import com.example.javaee_practise.model.user;
import com.example.javaee_practise.service.userService;
import com.example.javaee_practise.utilts.jdbc;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/login")
public class loginServlet extends HttpServlet {
    private userService myuserService = new userService();
    @Override
    public void init() {
        // Servlet初始化代码
        System.out.println("LoginServlet initialized");
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理GET请求
        user user = (user) request.getSession().getAttribute("user");
        System.out.println("Username from session: " + user);
        response.setContentType("application/json;charset=UTF-8");
        // 构造一个json数据
        JSONObject jsonResponse = new JSONObject();
        if(user != null){
            jsonResponse.put("user", new userDto(user).toJson());
            JSONArray jsonArray = new JSONArray();
            for(userDto userDto : myuserService.getAllUserInfo()){
                jsonArray.put(userDto.toJson());
            }
            jsonResponse.put("allUser", jsonArray);
            PrintWriter out = response.getWriter();
            out.write(jsonResponse.toString());
            out.flush();
        }
        else {
            // 设置响应类型为 JSON

            jsonResponse.put("username", user.getUsername() == null ? "您还尚未登录" : user.getUsername());
            PrintWriter out = response.getWriter();
            out.write(jsonResponse.toString());
            out.flush();
        }
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理POST请求
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user myuser = new user(username,password);
        if(myuserService.ifLogin(myuser)){//jdbc判断是否为真
            request.getSession().setAttribute("user", myuser);
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
