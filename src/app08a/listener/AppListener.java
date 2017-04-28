package app08a.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lambor on 17-4-28.
 */
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        Map<String,String> countries = new HashMap<>();
        countries.put("ca","Canada");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
