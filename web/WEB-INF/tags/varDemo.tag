<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-4-28
  Time: 下午3:04
  To change this template use File | Settings | File Templates.
--%>
<%@ tag import="java.util.Date" import="java.text.DateFormat"%>
<%@ variable name-given="longDate" %>
<%@ variable name-given="shortDate" %>
<%
    System.out.println("varDemo tag doBody");
    Date now = new Date(System.currentTimeMillis());
    DateFormat longFormat = DateFormat.getDateInstance(DateFormat.LONG);
    DateFormat shortFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    jspContext.setAttribute("longDate",longFormat.format(now));
    jspContext.setAttribute("shortDate",shortFormat.format(now));
%>
<jsp:doBody/>