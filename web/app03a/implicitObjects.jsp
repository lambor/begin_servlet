<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-4-25
  Time: 下午3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Implicit Objects</title>
</head>
<body>
<%
    for(Enumeration<String> e = request.getHeaderNames();e.hasMoreElements();) {
        String header = e.nextElement();
        out.println(header +":"+request.getHeaders(header) + "<br/>");
    }
%>
<hr/>
<%
    out.println("Buffer size:" + response.getBufferSize() + "<br/>");
    out.println("Session id: " + session.getId() + "<br/>");
    out.println("Servlet name: " + config.getServletName() + "<br/>");
    out.println("Server info:" + application.getServerInfo());
%>
</body>
</html>
