<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-5-17
  Time: 下午2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Product</title>
</head>
<body>
<br id="global">
<h4>The product has been saved.</h4>
<p>
<h5>Details:</h5>
Product Name: ${product.name}<br/>
Description: ${product.description}<br/>
Price: $${product.price}
<ol>
    <c:forEach items="${product.images}" var="image">
        <li>${image.originalFilename}
        <img width="100" src="<c:url value="/images/"/>${image.originalFilename}"/>
        </li>
    </c:forEach>
</ol>
</p>
</div>
</body>
</html>