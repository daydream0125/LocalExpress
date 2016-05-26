package com.localexpress.controller;

import com.localexpress.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserAssess")
public class UserAssess extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取待评价用户的用户名和评价等级
        String acceptName = request.getParameter("acceptName");
        String assess = request.getParameter("userAssess");

        UserService userService = new UserService();
        try {
            //将信息写入数据库
            userService.assessUser(acceptName,Integer.parseInt(assess));
            request.getRequestDispatcher("user_manage/user_manage.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
