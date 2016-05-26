package com.localexpress.controller;

import com.localexpress.model.TravelInfo;
import com.localexpress.model.User;
import com.localexpress.services.TravelInfoService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@WebServlet("/IssueInfo")
public class IssueInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        HttpSession session = request.getSession();
        //获取参数;new String(request.getParameter("from").getBytes("iso8859-1"), "utf-8")
        User user = (User) session.getAttribute("user");
        String userName = user.getUserName();
        String from = request.getParameter("fromAddress");
        String fromTime = request.getParameter("fromTime");
        String to = request.getParameter("toAddress");
        String toTime = request.getParameter("toTime");

        //封装行程信息
        TravelInfo travelInfo = new TravelInfo(userName, from, fromTime, to, toTime);
        TravelInfoService travelInfoService = new TravelInfoService();
        try {
            //添加至数据库
            travelInfoService.issueInfo(travelInfo);
            request.getRequestDispatcher("issue_info/issue_info_success.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            //出错转置错误界面
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }
}
