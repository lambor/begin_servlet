<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-4-26
  Time: 上午9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
accept-language:${header['accept-language']}
<br/>
session id: ${pageContext.session.id}
<br/>
employee: ${requestScope.employee.name},${employee.address.city},
<br/>
capital: ${capitals["Canada"]}
</body>
</html>
