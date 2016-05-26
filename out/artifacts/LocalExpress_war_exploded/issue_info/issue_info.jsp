<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE HTML>
<html>
<head>

    <base href="http://localhost:8080/LocalExpress/">

    <link href="res/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="res/css/style.css" rel='stylesheet' type='text/css'/>


    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <style>
        div{
            -webkit-border-radius: 15px;
            -moz-border-radius: 15px;
        }
        table {
            text-align: center;
            border-collapse: collapse;
            font-size: larger;
        }

        #tr1 {
            color: dodgerblue;
        }

        td {
            width: 200px;
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
                    <li><a href="send_express/send_express.jsp">发送快递</a></li>
                    <li><a href="accept_express/accept_express.jsp">接受快递</a></li>
                    <li class="active"><a href="issue_info/issue_info.jsp">发布信息</a></li>
                    <li><a href="user_manage/user_manage.jsp">账户管理</a></li>
                </ul>
            </div>
        </nav>
    </div>
</div>
<!---->
<div class="services">
    <div class="container">
        <h3 class="type">发布信息</h3><br/>
        <div class="contact-top">
            <form action="IssueInfo" method="post">
                <table align="center">
                    <tr id="tr1">
                        <td>出发地</td>
                        <td>目的地</td>
                        <td>出发时间</td>
                        <td>到达时间</td>
                    </tr>
                    <tr>
                        <td><input type="text" name="fromAddress" required="" ></td>
                        <td><input type="text" name="toAddress" required="" ></td>
                        <td><input type="text" name="fromTime" required="" ></td>
                        <td><input type="text" name="toTime" required=""  ></td>
                    </tr>
                </table>
                <br/>
                <input type="submit" value="发布" style="background: gainsboro">
                <input type="reset" value="重置"  style="background: gainsboro">
            </form>
        </div>
    </div>
</div>

</body>
</html>