<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-4-26
  Time: 上午11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>JSTL Core</title>
</head>
<body>
<c:out value="hello jstl"/>
<br/>
<c:out value="${foo}"/>
<c:set var="foo" value="hello foo"/>
<c:out value="${foo}"/>
<br/>
<c:if var="loggedIn" test="${param.user=='ken' && param.password=='blackcomb'}"/>
${loggedIn?"You logged in successfully":"Login failed"}
<br/>
<jsp:useBean id="member" class="app05a.model.Member"/>
<c:set target="${member}" property="status" value="full"/>
<c:choose>
    <c:when test="${member.status=='full'}">
        You are a full member
    </c:when>
    <c:when test="${member.status=='student'}">
        You are a student member
    </c:when>
    <c:otherwise>
        Please register
    </c:otherwise>
</c:choose>
<br/>
<c:forTokens var="item" items="hello,world,java" delims=",">
    <c:out value="${item}"/><br/>
</c:forTokens>
</body>
</html>
