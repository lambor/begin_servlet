<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-5-17
  Time: 下午2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product Form</title>
</head>
<body>
<div>
    <c:if test="${requestScope.errors != null}">
        <p id="errors">
            Error(s)!
        <ul>
        <c:forEach var="error" items="${requestScope.errors}">
            <li>${error}</li>
        </c:forEach>
        </ul>
        </p>
    </c:if>
    <form action="product_save2" method="post">
        <fieldset>
            <legend>Add a product</legend>
            <p>
                <label for="name">Product Name: </label>
                <input type="text" id="name" name="name" tabindex="1">
            </p>
            <p>
                <label for="description">Description: </label>
                <input type="text" id="description" name="description" tabindex="2">
            </p>
            <p>
                <label for="price">Price: </label>
                <input type="text" id="price" name="price" tabindex="3">
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5" value="Add Product">
            </p>
        </fieldset>
    </form>
</div>
</body>
</html>
