<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-4-28
  Time: 下午3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ attribute name="productDetails" fragment="true" %>
<%@ variable name-given="productName" %>
<%@ variable name-given="description" %>
<%@ variable name-given="price" %>
<%
    jspContext.setAttribute("productName","Pelesonic DVD Player");
    jspContext.setAttribute("description","Dolby Digital output through coaxial digital-audio jack");
    jspContext.setAttribute("price","65");
%>
<jsp:invoke fragment="productDetails"/>