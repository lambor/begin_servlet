<%@ page import="app08a.listener.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-5-9
  Time: 下午2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Country List</title>
</head>
<body>
We operate in these countries:
<ul>
    <c:forEach items="${countries}" var="country">
        <li>${country.value}</li>
    </c:forEach>
</ul>
<%
    session.setAttribute("product",new Product());
    session.removeAttribute("product");
%>
</body>
</html>
