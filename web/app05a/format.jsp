<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-4-26
  Time: 下午12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>JSTL Format</title>
</head>
<body>
<fmt:formatNumber value="12" type="number"/><br/>
<fmt:formatNumber value="12" type="number" minIntegerDigits="3"/><br/>
<fmt:formatNumber value="12" type="number" minFractionDigits="2"/><br/>
<fmt:formatNumber value="123456.78" pattern=".000"/><br/>
<fmt:formatNumber value="123456.78" pattern="#,#00.0#"/><br/>
<fmt:formatNumber value="12" type="currency"/><br/>
<fmt:formatNumber value="12" type="currency" currencyCode="USD"/><br/>
<fmt:formatNumber value="0.12" type="percent"/><br/>
<fmt:formatNumber value="0.125" type="percent" minFractionDigits="2"/><br/>
<hr/>
<jsp:useBean id="now" class="java.util.Date" scope="page"/>
Default: <fmt:formatDate value="${now}"/><br/>
Short: <fmt:formatDate value="${now}" dateStyle="short"/><br/>
Medium: <fmt:formatDate value="${now}" dateStyle="medium"/><br/>
Long: <fmt:formatDate value="${now}" dateStyle="long"/><br/>
Full: <fmt:formatDate value="${now}" dateStyle="full"/><br/>
<hr/>
<%
    Date now2 = new Date();
    request.setAttribute("now2", now2);
%>
Default: <fmt:formatDate type="time" value="${now2}"/><br/>
Short: <fmt:formatDate type="time" value="${now2}" timeStyle="short"/><br/>
Medium: <fmt:formatDate type="time" value="${now2}" timeStyle="medium"/><br/>
Long: <fmt:formatDate type="time" value="${now2}" timeStyle="long"/><br/>
Full: <fmt:formatDate type="time" value="${now2}" timeStyle="full"/><br/>
<hr/>
Default: <fmt:formatDate type="both" value="${now}"/><br/>
Short: <fmt:formatDate type="both" value="${now}" dateStyle="short" timeStyle="short"/><br/>
Long: <fmt:formatDate type="both" value="${now}" dateStyle="long" timeStyle="long"/><br/>
<hr/>
Time zone CT: <fmt:formatDate type="time" value="${now}" timeZone="CT"/><br/>
Time zone HST: <fmt:formatDate type="time" value="${now}" timeZone="HST"/><br/>
<hr/>
<c:set var="quantity" value="20"/>
<fmt:parseNumber var="formattedNumber" type="number" value="${quantity}"/>
Quantity:${formattedNumber}<br/>
<c:set var="myDate" value="12/12/2005"/>
<fmt:parseDate value="${myDate}" type="date" pattern="dd/MM/yyyy" var="formattedDate"/>
MyDate:${formattedDate}
</body>
</html>
