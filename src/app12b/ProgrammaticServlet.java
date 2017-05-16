package app12b;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lambor on 17-5-16.
 */
@WebServlet(urlPatterns = {"/app12b/prog"})
public class ProgrammaticServlet extends HttpServlet {
    private static final long serialVersionUID = 87620L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.authenticate(resp)) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("Welcome");
        } else {
            System.out.println("User not authenticated");
        }
    }
}
