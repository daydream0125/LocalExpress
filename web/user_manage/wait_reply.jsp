<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>

    <base href="http://localhost:8080/LocalExpress/">

    <link href="res/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="res/css/style.css" rel='stylesheet' type='text/css'/>


    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <style>
        table {
            text-align: center;
            border-collapse: collapse;
            font-size: larger;
        }

        #tr1 {
            color: dodgerblue;
        }

        td {
            width: 180px;
            height: auto;
        }
    </style>
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
                    <li ><a href="send_express/send_express.jsp">发送快递</a></li>
                    <li ><a href="accept_express/accept_express.jsp">接受快递</a></li>
                    <li ><a href="issue_info/issue_info.jsp">发布信息</a></li>
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
        <ol class="breadcrumb">
            <li><a href="user_manage/user_manage.jsp">账户管理</a></li>
            <li class="active">确认</li>
        </ol>
        <div class="contact-top">
            <h1>已确认,等待对方确认</h1>
        </div>
    </div>
</div>

</body>
</html>