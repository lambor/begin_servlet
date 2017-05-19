<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-5-19
  Time: 上午11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee Form</title>
</head>
<body>
<div id="global">
    <form:form commandName="employee" action="employee_save" method="post">
        <fieldset>
            <legend>Add an employee</legend>
            <p>
                <label for="firstName">First Name:</label>
                <form:input path="firstName" tabindex="1"/>
            </p>
            <p>
                <label for="lastName">First Name:</label>
                <form:input path="lastName" tabindex="2"/>
            </p>
            <p>
                <form:errors path="birthDate"/>
            </p>
            <p>
                <label for="birthDate">Date of Birth:</label>
                <form:input path="birthDate" tabindex="3"/>
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5" value="Add Employee">
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>
