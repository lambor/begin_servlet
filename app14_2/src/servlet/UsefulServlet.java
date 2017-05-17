package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lambor on 17-5-17.
 */
public class UsefulServlet extends HttpServlet {
    private static final long serialVersionUID = -6045338L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>First servlet" + "</title></head><body>" + "useful servlet");
        writer.println("</body></head>");
    }

}
