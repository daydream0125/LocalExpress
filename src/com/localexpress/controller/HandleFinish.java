package com.localexpress.controller;

import com.localexpress.model.User;
import com.localexpress.services.SendExpressService;
import com.localexpress.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/HandleFinish")
public class HandleFinish extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


    //判断本次快递派送是否完成
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        SendExpressService sendExpressService = new SendExpressService();
        String finish = request.getParameter("finish");
        if (finish.equals("1")) {
            try {
                //进行金额的扣除
                sendExpressService.updateFinish1(user.getUserName());

                if (sendExpressService.isFinish(user.getUserName())) {
                    sendExpressService.updateMoney(user.getUserName());
                    request.getRequestDispatcher("accept_express/finish.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("accept_express/wait_reply.jsp").forward(request, response);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (finish.equals("2")) {

            try {
                sendExpressService.updateFinish2(user.getUserName());

                if (sendExpressService.isFinish(user.getUserName())) {
                    sendExpressService.updateMoney(user.getUserName());
                    UserService userService = new UserService();
                    User newUser = userService.getUserByName(user.getUserName()) ;

                    //更新session中的user信息

                    session.setAttribute("user",newUser);

                    request.getRequestDispatcher("accept_express/finish.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("user_manage/wait_reply.jsp").forward(request, response);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
