<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-4-27
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="easy" uri="/WEB-INF/mytags.tld" %>
<html>
<head>
    <title>Testing SelectElementFormatterTag</title>
</head>
<body>
<easy:select>
    <option value="${value}">${text}</option>
</easy:select>
</body>
</html>
