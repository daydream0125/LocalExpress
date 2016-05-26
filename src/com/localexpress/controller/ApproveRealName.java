package com.localexpress.controller;

import com.localexpress.model.User;
import com.localexpress.util.SendMail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ApproveRealName")
public class ApproveRealName extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理实名认证,通过发送邮件,判断用户输入的验证码和系统发送的验证码是否匹配
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        //从session中获得当前登录对象
        User user = (User) session.getAttribute("user");

        //判断用户是否已经实名认证
        if (user.getFlag().equals("true")) {
            request.setAttribute("flag","true");
            request.getRequestDispatcher("user_manage/user_manage.jsp").forward(request, response);
            return;
        }

        String email = user.getEmail();

        //发送邮件,并得到验证码,加入session中
        try {
            String key = SendMail.sendMail(email);
            session.setAttribute("key", key);

            request.getRequestDispatcher("user_manage/approve_realname.jsp").forward(request, response);
        } catch (Exception e) {

            //发生异常则转向错误页面
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }


    }
}
