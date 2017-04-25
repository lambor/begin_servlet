<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-4-25
  Time: 下午4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="errorHandler.jsp" %>
<html>
<head>
    <title>Buggy Page</title>
</head>
<body>
Deliberately throw an exception
<%
    Integer.parseInt("Throw me");
%>
</body>
</html>
