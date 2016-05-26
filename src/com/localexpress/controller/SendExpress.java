package com.localexpress.controller;

import com.localexpress.model.TravelInfo;
import com.localexpress.model.User;
import com.localexpress.services.TravelInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SendExpress")
public class SendExpress extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        TravelInfoService travelInfoService = new TravelInfoService();

        //存放行程信息
        List<TravelInfo> list = null;

        //获取用户请求类型
        String info = request.getParameter("info");

        if (info.equals("all")) {
            //获取全部行程信息
            try {
                list = travelInfoService.getAllTravleInfo(user.getUserName());

                request.setAttribute("list", list);
                request.getRequestDispatcher("send_express/check_all_info.jsp").forward(request, response);
            } catch (SQLException e) {

                e.printStackTrace();
                //发生异常转至错误界面
                request.getRequestDispatcher("error.jsp").forward(request, response);

            }
        } else if (info.equals("search")) {
            //获取搜索条件
            String fromAddress = request.getParameter("fromAddress");
            String toAddress = request.getParameter("toAddress");
            try {
                list = travelInfoService.getTravelInfoBySearch(fromAddress, toAddress,user.getUserName());
                request.setAttribute("list", list);
                request.getRequestDispatcher("send_express/check_by_search.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                //发生异常转至错误界面
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }

    }
}
