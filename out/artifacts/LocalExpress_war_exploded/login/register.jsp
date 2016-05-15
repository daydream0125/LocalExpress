<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE HTML>
<html>
<head>

    <base href="http://localhost:8080/LocalExpress/">

    <link href="login/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Custom Theme files -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

</head>
<style>
    #register_table{
        align-content: center;
        align-self: center;
        align-items:center;
        font-size: large;
        margin: 0px auto;

    }
    body{
        text-align: center;
        align-content: center;
        align-items: center;

    }
    p{
        font-family: "Andale Mono";
        font-size: 60px;
    }
</style>
<body>
<div class="main">
    <p>
        Local Express
    </p><br/>
    <form method="post" action="Register">
        <table id="register_table">
            <tr>
                <td>
                    用户名
                </td>
                <td>
                    <input type="text"  required="" name="username"><br/>
                </td>
            </tr>
            <tr>
                <td>
                    密码
                </td>
                <td>
                    <input type="password"  required="" name="password"><br/>
                </td>
            </tr>

            <tr>
                <td>
                    性别
                </td>
                <td>
                    <input type="radio" name="sex" value="男"  > 男
                    <input type="radio" name="sex" value="女"> 女 <br/>
                </td>
            </tr>
            <tr>
                <td>
                    手机
                </td>
                <td>
                    <input type="text" required="" name="tel"><br/>

                </td>
            </tr>
            <tr>
                <td>
                    邮箱
                </td>
                <td>
                    <input type="text" required="" name="email"><br/>

                </td>
            </tr>
            <tr>
                <td>
                    真实姓名
                </td>
                <td>
                    <input type="text" required="" name="realname"><br/>
                </td>
            </tr>
            <tr>
                <td>
                    居住地址

                </td>
                <td>
                    <input type="text"  required="" name="address"><br/>

                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <input type="submit" value="注册">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
    <%
        //判断是否回传参数信息,回传则说明用户名已存在,提示用户
        String err = request.getParameter("err");
        if (err != null) {
            out.print("<p style='color:red;font-size:10px'>用户名已存在!</p>");
        }
    %>
</div>
<div class="footer">
    <p>&copy 2016 Local Express Login Form . All rights reserved | Design by <a >Five Old Star.</a></p>
</div>
</body>
</html>
