<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<div id="global">
    Current Locale: ${pageContext.response.locale}<br/>
    accept-language header: ${header["accept-language"]}
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
    <form action="product_save.action" method="post">
        <fieldset>
            <legend><spring:message code="page.productform.title"/></legend>
            <p>
                <label for="name"><spring:message code="label.productName" text="default text"/></label>
                <input type="text" id="name" name="name" tabindex="1">
            </p>
            <p>
                <label for="description"><spring:message code="label.description"/></label>
                <input type="text" id="description" name="description" tabindex="2">
            </p>
            <p>
                <label for="price"><spring:message code="label.price" text="default text"/></label>
                <input type="text" id="price" name="price" tabindex="3">
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4" value="<spring:message code="button.reset"/>">
                <input id="submit" type="submit" tabindex="5" value="<spring:message code="button.submit"/>">
            </p>
        </fieldset>
    </form>
</div>
</body>
</html>
