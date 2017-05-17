package app16a.servlet;

import app16a.controller.InputProductController;
import app16a.controller.SaveProductController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lambor on 17-5-17.
 */
@WebServlet(
        urlPatterns = {"/app16a/*"}
)
public class DispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = 748495L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    private void process(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);

        String dispatchUrl = null;
        if(action.equals("product_input.action")) {
            InputProductController controller = new InputProductController();
            dispatchUrl = controller.handleRequest(req,resp);
        } else if(action.equals("product_save.action")) {
            SaveProductController controller = new SaveProductController();
            dispatchUrl = controller.handleRequest(req,resp);
        }

        if(dispatchUrl != null) {
            RequestDispatcher rd = req.getRequestDispatcher(dispatchUrl);
            rd.forward(req,resp);
        }
    }
}
