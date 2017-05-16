package app12b;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lambor on 17-5-15.
 */
@WebServlet(
        urlPatterns = {"/app12b/servlet1"}
)
public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = -15560L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/app12b/1.jsp");
        dispatcher.forward(req,resp);
    }
}
