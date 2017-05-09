package app08a.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lambor on 17-5-9.
 */
@WebListener
public class SessionListener implements HttpSessionListener, ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("userCounter",new AtomicInteger());

        Map<String,String> countries = new HashMap<>();
        countries.put("ca","Canada");
        countries.put("us","United States");
        servletContext.setAttribute("countries",countries);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ServletContext servletContext = session.getServletContext();
        AtomicInteger userCounter = (AtomicInteger) servletContext.getAttribute("userCounter");
        int userCount = userCounter.incrementAndGet();
        System.out.println("userCounter incremented to :" + userCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ServletContext servletContext = session.getServletContext();
        AtomicInteger userCounter = (AtomicInteger) servletContext.getAttribute("userCounter");
        int userCount = userCounter.decrementAndGet();
        System.out.println("userCounter decremented to :" + userCount);
    }
}
