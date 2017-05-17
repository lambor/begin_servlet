package app16a.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lambor on 17-5-17.
 */
public interface Controller {
    String handleRequest(HttpServletRequest req, HttpServletResponse resp);
}
