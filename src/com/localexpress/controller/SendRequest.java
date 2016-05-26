package com.localexpress.controller;

import com.localexpress.model.RequestInfo;
import com.localexpress.model.User;
import com.localexpress.services.RequestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/SendRequest")
public class SendRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //从session中获取当前登陆对象
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        //获取参数
        String requestName = user.getUserName();
        String acceptName = request.getParameter("acceptName");
        String travelID = request.getParameter("travelID");

        //封装请求信息
        RequestInfo requestInfo = new RequestInfo(requestName,acceptName,Integer.parseInt(travelID));
        RequestService requestService = new RequestService();
        try {
            if(requestService.sendRequest(requestInfo)) {
                request.getRequestDispatcher("send_express/send_success.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp");
        }

    }
}
