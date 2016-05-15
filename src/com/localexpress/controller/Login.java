package com.localexpress.controller;

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
        UserService userService = new UserService();
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            if(userService.checkUser(userName,password)) {
                HttpSession session = request.getSession();
                session.setAttribute("userName",userName);
                request.getRequestDispatcher("index.jsp").forward(request,response);
            } else {
                request.getRequestDispatcher("login/login.jsp?err='aaa'").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
