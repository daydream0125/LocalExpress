<%--
  Created by IntelliJ IDEA.
  User: hanhao0125
  Date: 16/5/18
  Time: 下午11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%request.setCharacterEncoding("UTF-8");response.setContentType("text/html;charset=utf-8");
    %>
    ${a}
    <%
        System.out.println(request.getParameter("a"));
    %>

</body>
</html>
