package app01b;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.StringJoiner;

/**
 * Created by lambor on 17-4-24.
 */
@WebServlet(name = "FormServlet", urlPatterns = {"/form"})
public class FormServlet extends HttpServlet {
    private static final long serialVersionUID = 54l;
    private static final String TITLE = "Order Form";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method=\"post\">\n" +
                "\n" +
                "    <style type=\"text/css\">\n" +
                "        .tg {\n" +
                "            border-collapse: collapse;\n" +
                "            border-spacing: 0;\n" +
                "        }\n" +
                "\n" +
                "        .tg td {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            font-size: 14px;\n" +
                "            padding: 10px 20px;\n" +
                "            border-style: solid;\n" +
                "            border-width: 1px;\n" +
                "            overflow: hidden;\n" +
                "            word-break: normal;\n" +
                "        }\n" +
                "\n" +
                "        .tg th {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            font-size: 14px;\n" +
                "            font-weight: normal;\n" +
                "            padding: 10px 20px;\n" +
                "            border-style: solid;\n" +
                "            border-width: 1px;\n" +
                "            overflow: hidden;\n" +
                "            word-break: normal;\n" +
                "        }\n" +
                "\n" +
                "        .tg .tg-yw4l {\n" +
                "            vertical-align: top\n" +
                "        }\n" +
                "    </style>\n" +
                "    <table class=\"tg\">\n" +
                "        <tr>\n" +
                "            <th class=\"tg-031e\">name:</th>\n" +
                "            <th class=\"tg-yw4l\"><input name=\"name\"/></th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"tg-yw4l\">address:</td>\n" +
                "            <td class=\"tg-yw4l\"><textarea name=\"address\" cols=\"40\" rows=\"5\"></textarea></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"tg-yw4l\">country:</td>\n" +
                "            <td class=\"tg-yw4l\">\n" +
                "                <select name=\"country\">\n" +
                "                    <option>United States</option>\n" +
                "                    <option>Canada</option>\n" +
                "                </select>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"tg-yw4l\">delivery method:</td>\n" +
                "            <td class=\"tg-yw4l\">\n" +
                "                <input type=\"radio\" name=\"deliveryMethod\" value=\"First Class\"/>First Class\n" +
                "                <input type=\"radio\" name=\"deliveryMethod\" value=\"Second Class\"/>Second Class\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"tg-yw4l\">shipping instructions:</td>\n" +
                "            <td class=\"tg-yw4l\"><textarea name=\"instruction\" cols=\"40\" rows=\"5\"></textarea></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"tg-yw4l\"></td>\n" +
                "            <td class=\"tg-yw4l\"><textarea name=\"instruction\" cols=\"40\" rows=\"5\"></textarea></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"tg-yw4l\">please send me the latest product catalog:</td>\n" +
                "            <td class=\"tg-yw4l\"><input type=\"checkbox\" name=\"catalogRequest\"/></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td class=\"tg-yw4l\"></td>\n" +
                "            <td class=\"tg-yw4l\">\n" +
                "                <input type=\"reset\"/>\n" +
                "                <input type=\"submit\"/>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body><h1>"+TITLE+"</h1>");
        writer.println("<div style='border:1px solid #ddd; margin-top:40px; font-size:90%'>");
        writer.println("Debug Info<br/>");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            writer.println(paramName + ":");
            String[] paramValues = req.getParameterValues(paramName);
            for(String paramValue:paramValues) {
                writer.println(paramValue + "<br/>");
            }
        }
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
