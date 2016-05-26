package com.localexpress.controller;

import com.localexpress.model.RequestInfo;
import com.localexpress.model.TravelInfo;
import com.localexpress.model.User;
import com.localexpress.services.RequestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/CheckRequest")
public class CheckRequest extends HttpServlet {
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

        //将请求路线信息放置request域中
        try {
            TravelInfo travelInfo = requestService.getRequestTravelInfo(user.getUserName());
            request.setAttribute("travelInfo", travelInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            List<RequestInfo> requestList = requestService.getAllRequest(user.getUserName());
            if (requestList.size() == 0) {
                //没有用户请求
                request.getRequestDispatcher("accept_express/check_all_request.jsp").forward(request, response);
            } else {
                request.setAttribute("list", requestList);
                request.getRequestDispatcher("accept_express/check_all_request.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
