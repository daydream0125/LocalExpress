<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE HTML>
<html>
<head>

    <base href="http://localhost:8080/LocalExpress/">
    <link href="login/css/style.css" rel="stylesheet" type="text/css" media="all"/>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

</head>
<body>
<div class="main">
    <div class="login">
        <div class="login-top">
            <img src="login/images/p.png">
        </div>
        <h1>Local Express</h1>
        <div class="login-bottom">
            <form action="Login" method="post">
                <input type="text" placeholder="Username" required="" name="username">
                <input type="password" class="password" placeholder="Password" required="" name="password">
                <input type="submit" value="login">
            </form>

            <%
                //判断是否回传参数信息,回传则说明用户名或密码出错,提示用户
                String err = request.getParameter("err");
                if (err != null) {
                    out.print("<p style='color:red'>用户名或密码出错</p>");
                }
            %>

            <a href="register.jsp"><p>Not a Member? Click Here</p></a>
        </div>
    </div>
</div>
<div class="footer">
    <p>&copy 2016 Local Express Login Form . All rights reserved | Design by <a>Five Old Star.</a></p>
</div>
</body>
</html>
