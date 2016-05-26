<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>

    <base href="http://localhost:8080/LocalExpress/">

    <link href="res/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="res/css/style.css" rel='stylesheet' type='text/css'/>


    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

</head>

<body>
<!-- banner -->
<div class="banner banner2">
    <div class="container">
        <div class="header">
            <div class="logo">
                <h1><a href="index.jsp"><img src="res/images/car.png"/>Local <span>Express</span></a></h1>
            </div>

            <div class="clearfix"></div>
        </div>
        <nav class="navbar navbar-default">

            <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="index.jsp">主页 <span class="sr-only">(current)</span></a></li>
                    <li><a href="about.html">About</a></li>
                    <li><a href="send_express/send_express.jsp">发送快递</a></li>
                    <li><a href="accept_express/accept_express.jsp">接受快递</a></li>
                    <li><a href="issue_info/issue_info.jsp">发布信息</a></li>
                    <li class="active"><a href="user_manage/user_manage.jsp">账户管理</a></li>
                </ul>
            </div>
        </nav>
    </div>
</div>
<!---->
<div class="services">
    <div class="container">
        <h3 class="type">账户管理</h3>
        <div class="contact-top">
            <br>

            <h1 class="btns">
                <a href="ApproveRealName"><span class="label label-success">实名认证   </span></a>
            </h1>

            <h1 class="btns">
                <a href="user_manage/check_info.jsp"><span class="label label-success">查看个人信息</span></a>
            </h1>

            <h1 class="btns">
                <a href="user_manage/change_info.jsp"><span class="label label-success">更改个人信息</span></a>
            </h1>
            <h1 class="btns">
                <a href="CheckExpressInfo"><span class="label label-success">查看快递信息</span></a>
            </h1>
            <h1 class="btns">
                <a href="CheckAllExpress"><span class="label label-success">查看快递记录</span></a>
            </h1>
        </div>
    </div>
</div>

    <!-- 判断是否实名认证 -->
    <c:if test="${flag != null && flag == 'true'}">
        <script>
            alert("您已经实名认证成功,无需重复操作!")
        </script>
    </c:if>

</body>
</html>