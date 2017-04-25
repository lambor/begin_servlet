<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-4-25
  Time: 下午3:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    public String getTodaysDate() {
        return new java.util.Date().toLocaleString();
    }
%>
<html>
<head>
    <title>Declarations</title>
</head>
<body>
Today is <%=getTodaysDate()%>
</body>
</html>
