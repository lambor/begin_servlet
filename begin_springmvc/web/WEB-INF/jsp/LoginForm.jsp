<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-5-23
  Time: 下午2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form:form commandName="login" action="login" method="post">
    <fieldset>
        <legend>Login</legend>
        <p>
            <label for="userName">User Name:</label>
            <form:input id="userName" path="userName"/>
        </p>
        <p>
            <label for="password">Password:</label>
            <form:input id="password" path="password"/>
        </p>
        <p>
            <input id="reset" type="reset" tabindex="4"/>
            <input id="submit" type="submit" tabindex="5"/>
        </p>
    </fieldset>
</form:form>
</body>
</html>
