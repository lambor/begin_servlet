package app16a.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lambor on 17-5-17.
 */
public class InputProductController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        return "/WEB-INF/jsp/ProductForm.jsp";
    }
}
