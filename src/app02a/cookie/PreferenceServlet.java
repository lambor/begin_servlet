package app02a.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lambor on 17-4-24.
 */
@WebServlet(name = "PreferenceServlet", urlPatterns = {"/preference"})
public class PreferenceServlet extends HttpServlet {
    private static final long serialVersionUID = 888L;
    public static final String MENU = "<div styl='background:#e8e8e8;padding:15px'>" +
            "<a href='cookieClass'>Cookie Class</a>&nbsp;&nbsp;" +
            "<a href='cookieInfo'>Cookie Info</a>&nbsp;&nbsp;" +
            "<a href='preference'>Preference</a>" + "</div>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" + MENU +
                "Please select the values below:\n" +
                "<style type=\"text/css\">\n" +
                "    .tg {\n" +
                "        border-collapse: collapse;\n" +
                "        border-spacing: 0;\n" +
                "    }\n" +
                "\n" +
                "    .tg td {\n" +
                "        font-family: Arial, sans-serif;\n" +
                "        font-size: 14px;\n" +
                "        padding: 10px 20px;\n" +
                "        border-style: solid;\n" +
                "        border-width: 1px;\n" +
                "        overflow: hidden;\n" +
                "        word-break: normal;\n" +
                "    }\n" +
                "\n" +
                "    .tg th {\n" +
                "        font-family: Arial, sans-serif;\n" +
                "        font-size: 14px;\n" +
                "        font-weight: normal;\n" +
                "        padding: 10px 20px;\n" +
                "        border-style: solid;\n" +
                "        border-width: 1px;\n" +
                "        overflow: hidden;\n" +
                "        word-break: normal;\n" +
                "    }\n" +
                "\n" +
                "    .tg .tg-yw4l {\n" +
                "        vertical-align: top\n" +
                "    }\n" +
                "</style>\n" +
                "<form method=\"post\">\n" +
                "    <table class=\"tg\">\n" +
                "        <tr>\n" +
                "            <th class=\"tg-031e\">the font size:</th>\n" +
                "            <th class=\"tg-yw4l\">\n" +
                "                <select name=\"titleFontSize\">\n" +
                "                    <option>large</option>\n" +
                "                    <option>x-large</option>\n" +
                "                    <option>xx-large</option>\n" +
                "                </select>\n" +
                "            </th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"tg-yw4l\">title style &amp; weight:</td>\n" +
                "            <td class=\"tg-yw4l\">\n" +
                "                <select name=\"titleStyleAndWeight\" multiple>\n" +
                "                    <option>italic</option>\n" +
                "                    <option>bold</option>\n" +
                "                </select>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"tg-yw4l\">max records in table:</td>\n" +
                "            <td class=\"tg-yw4l\">\n" +
                "                <select name=\"maxRecords\">\n" +
                "                    <option>5</option>\n" +
                "                    <option>10</option>\n" +
                "                </select>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"tg-yw4l\"></td>\n" +
                "            <td class=\"tg-yw4l\"><input type=\"submit\" value=\"Set\"></td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maxRecords = req.getParameter("maxRecords");
        String[] titleStyleAndWeight = req.getParameterValues("titleStyleAndWeight");
        String titleFontSize = req.getParameter("titleFontSize");
        resp.addCookie(new Cookie("maxRecords",maxRecords));
        resp.addCookie(new Cookie("titleFontSize",titleFontSize));

        Cookie cookie = new Cookie("titleFontWeight","");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        cookie = new Cookie("titleFontStyle","");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        if(titleStyleAndWeight != null) {
            for(String style:titleStyleAndWeight) {
                if(style.equals("bold")) {
                    resp.addCookie(new Cookie("titleFontWeight","bold"));
                } else if(style.equals("italic")) {
                    resp.addCookie(new Cookie("titleFontStyle","italic"));
                }
            }
        }

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head>" + "<title>Preference</title>"
                + "</head><body>" + MENU
                + "Your preference has been set."
                + "<br/><br/>Max. Records in Table: "+ maxRecords
                + "<br/>Title Font Size: "+ titleFontSize
                + "<br/>Title Font Style & Weight: ");

        if(titleStyleAndWeight != null) {
            writer.println("<ul>");
            for(String style:titleStyleAndWeight) {
                writer.print("<li>" + style + "</li>");
            }
            writer.println("</ul>");
        }
        writer.println("</body></html>");
    }
}
