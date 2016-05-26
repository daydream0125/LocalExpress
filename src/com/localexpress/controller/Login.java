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

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();

        UserService userService = new UserService();
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = userService.checkUser(userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user != null) {
            //用户有效则将该用户信息封装到session中
            session.setAttribute("user", user);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            //用户信息无效则将错误信息放置在request中,采用相同的参数名user是为了前台验证方便
            request.setAttribute("user","failed");
            request.getRequestDispatcher("login/login.jsp").forward(request, response);
        }

    }
}
