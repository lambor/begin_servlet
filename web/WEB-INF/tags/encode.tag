<%--
  Created by IntelliJ IDEA.
  User: lambor
  Date: 17-4-28
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ attribute name="input" required="true" %>
<%!
    private String encodeHtmlTag(String tag) {
        if(tag == null) return null;

        int length = tag.length();
        StringBuilder encodeTag = new StringBuilder(2*length);
        for(int i=0;i<length;i++) {
            char c = tag.charAt(i);
            if(c == '<')
                encodeTag.append("&lt");
            else if(c == '>')
                encodeTag.append("&gt");
            else if(c == '&')
                encodeTag.append("&amp");
            else if(c == '"')
                encodeTag.append("&qout");
            else if(c==' ')
                encodeTag.append("&nbsp");
            else
                encodeTag.append(c);
        }
        return encodeTag.toString();
    }
%>
<%=encodeHtmlTag(input)%>
