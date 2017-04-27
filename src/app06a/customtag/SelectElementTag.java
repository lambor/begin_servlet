package app06a.customtag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by lambor on 17-4-27.
 */
public class SelectElementTag extends SimpleTagSupport {
    private String[] countries = {"Australia","Brazil","China"};

    public void doTag() throws IOException,JspException {
        JspContext jspContext = getJspContext();
        JspWriter out = jspContext.getOut();
        out.println("<select>");
        for(int i=0;i<3;i++) {
            getJspContext().setAttribute("value",countries[i]);
            getJspContext().setAttribute("text",countries[i]);
            getJspBody().invoke(out); //等价于 getJspBody().invoke(null);
        }
        out.println("</select>");
        System.out.println("doTag");
    }
}
