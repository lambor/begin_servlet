<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-4-25
  Time: 下午3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scriptlet example</title>
</head>
<body>
<%--first scriptlet--%>
<%
    for(Enumeration<String> e = request.getHeaderNames();e.hasMoreElements();) {
        String header = e.nextElement();
        out.println(header + ":" + request.getHeader(header) + "<br/>");
    }
    String message = "Thank you";
%>
<hr/>
<%--second scriptlet--%>
<%
    out.println(message);
%>
<%--expression--%>
Today is <%=java.util.Calendar.getInstance().getTime()%>
</body>
</html>
