<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-4-28
  Time: 下午3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
Today's date:
<br/>
<tags:varDemo>
    In long format: ${longDate}
    <br/>
    In short format: ${shortDate}
</tags:varDemo>