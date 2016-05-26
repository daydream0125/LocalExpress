<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hanhao0125
  Date: 16/5/18
  Time: 下午7:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    String a = "abc";
    request.setAttribute("abc",a);
%>
${abc}
    <c:if test="${abc == 'abc'}" >
        abc
        ${abc}
</c:if>
</body>
</html>
