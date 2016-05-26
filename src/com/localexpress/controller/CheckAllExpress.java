package com.localexpress.controller;

import com.localexpress.model.User;
import com.localexpress.services.SendExpressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/CheckAllExpress")
public class CheckAllExpress extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        SendExpressService sendExpressService = new SendExpressService();
        try {
            List list = sendExpressService.getExpressInfo(user.getUserName());
            request.setAttribute("list",list);
            request.getRequestDispatcher("user_manage/check_all_express.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
