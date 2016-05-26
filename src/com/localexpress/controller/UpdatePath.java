package com.localexpress.controller;

import com.localexpress.model.ExpressPath;
import com.localexpress.model.User;
import com.localexpress.services.SendExpressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Path;

@WebServlet("/UpdatePath")
public class UpdatePath extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        SendExpressService sendExpressService = new SendExpressService();
        String path = request.getParameter("path");

        try {
            ExpressPath expressPath = sendExpressService.getExpressPath2(user.getUserName());
            request.setAttribute("expressPath", expressPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            sendExpressService.updatePath(user.getUserName(), path);
            request.getRequestDispatcher("accept_express/update_success.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }
    }
}
