package app06a.customtag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by lambor on 17-4-27.
 */
public class DataFormatterTag extends SimpleTagSupport {
    private String header;
    private String items;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setItems(String items) {
        this.items = items;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspContext jspContext = getJspContext();
        JspWriter out = jspContext.getOut();

        out.println("<table style='border:1px solid green'>");
        out.println("<tr><td><span style='font-weight:bold'>" + header + "</span></td></tr>");
        StringTokenizer tokenizer = new StringTokenizer(items,",");
        while (tokenizer.hasMoreElements()) {
            String token = tokenizer.nextToken();
            out.println("<tr><td>" + token + "</td></tr>");
        }
        out.print("</table>");
    }
}
