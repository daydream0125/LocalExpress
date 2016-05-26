package com.localexpress.controller;

import com.localexpress.model.User;
import com.localexpress.services.RequestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AcceptRequest")
public class AcceptRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取当前登录用户
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        RequestService requestService = new RequestService();

        String requestName = request.getParameter("requestName");

        try {
            //接受快递请求,进行相应数据库的操作
            requestService.acceptRequest(requestName);
            request.getRequestDispatcher("accept_express/accept_success.jsp").forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
