package com.localexpress.controller;

import com.localexpress.model.User;
import com.localexpress.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码方式
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取注册信息
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String realName = request.getParameter("realname");

        User user = new User(userName, password, sex, tel, email, address, realName);
        UserService userService = new UserService();

        try {
            //判断用户名是否也存在,存在则提示用户,重新填写注册信息
            if (userService.userNameIsExist(userName)) {
                request.getRequestDispatcher("login/register.jsp?err='name is exist'").forward(request, response);
            } else
                try {
                    userService.addUser(user);
                    HttpSession session = request.getSession();
                    session.setAttribute("userName", userName);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("添加用户失败");
                    e.printStackTrace();
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
