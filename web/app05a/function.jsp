<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-4-26
  Time: 下午1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>JSTL Functions</title>
</head>
<body>
<c:set var="myString" value="Hello World"/>
${fn:contains(myString, "Hello")}<br/>
${fn:contains("Stella Cadente", "Cadente")}<br/>
${fn:containsIgnoreCase("Hello World", "helLo")}<br/>
${fn:endsWith("Hello World", "World")}
<hr/>

${fn:escapeXml("Use <br/> to change lines")}<br/>
${fn:indexOf("Stella Cadente", "Cadente")}<br/>
<hr/>

<%
    String[] arr = new String[]{"hello","there","java8"};
    request.setAttribute("myArray",arr);
%>
${fn:join(myArray, ",")}<br/>
myArray length: ${fn:length(myArray)}<br/>
"hello world" length: ${fn:length("hello world")}<br/>
${fn:replace("hello world", "h", "j")}<br/>
<hr/>

<c:set var="split" value="${fn:split('hello,world', ',')}"/>
<table>
    <c:forEach var="word" items="${split}">
        <tr>
            <td>${word}</td>
        </tr>
    </c:forEach>
</table>
${fn:startsWith("hello", "he")}<br/>
${fn:substring("hello world java8", 2, 6)}<br/>
${fn:substringAfter("hello world java8", "j")}<br/>
${fn:substringBefore("hello world java8", "j")}<br/>
lower case:${fn:toLowerCase("HELLO WORLD JAVA8")}<br/>
upper case:${fn:toUpperCase("hello world java8")}<br/>
trim:${fn:trim("  hello world java8   ")}<br/>
</body>
</html>
