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

@WebServlet("/CheckKey")
public class CheckKey extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证输入码和发送码是否一致
        HttpSession session = request.getSession();
        UserService userService = new UserService();
        User user = (User) session.getAttribute("user");
        String inputKey = request.getParameter("inputkey");
        String key = (String) session.getAttribute("key");
        String flag = "failed";
        if (inputKey.equals(key)) {
            try {
                //更新数据库flag标志
                userService.approveRealName(user.getUserName());

                //将session中的user信息更新
                user.setFlag("true");
                session.setAttribute("user",user);

            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("flag","success");
            //从session中移除key
            session.removeAttribute("key");
            request.getRequestDispatcher("user_manage/approve_realname.jsp").forward(request, response);


        } else {
            request.setAttribute("flag",flag);
            session.removeAttribute("key");
            request.getRequestDispatcher("user_manage/approve_realname.jsp").forward(request, response);

        }

    }
}
