package app14a;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/**
 * Created by lambor on 17-5-17.
 */
@WebListener
public class DynRegListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        Servlet firstServlet = null;
        try {
            firstServlet = servletContext.createServlet(FirstServlet.class);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        if(firstServlet != null && firstServlet instanceof FirstServlet) {
            ((FirstServlet) firstServlet).setName("Dynamically registered servlet");
        }

        ServletRegistration.Dynamic dynamic = servletContext.addServlet("firstServlet",firstServlet);
        dynamic.addMapping("/app14a/dynamic");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
