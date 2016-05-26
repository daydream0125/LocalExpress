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

@WebServlet("/ChangeUserInfo")
public class ChangeUserInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码方式
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        User userInSession = (User) session.getAttribute("user");


        //获取修改信息
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String realName = request.getParameter("realname");

        User user = new User(userInSession.getUserName(), password, userInSession.getSex(), tel, email, address, realName, userInSession.getFlag());
        UserService userService = new UserService();
        try {
            //更新用户信息
            userService.updateUserInfo(user);
            //更新session中的user信息
            session.setAttribute("user", user);
            request.getRequestDispatcher("user_manage/change_info_success.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("更新失败");
            e.printStackTrace();
        }
    }

}
