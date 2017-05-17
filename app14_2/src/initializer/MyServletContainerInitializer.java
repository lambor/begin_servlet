package initializer;

import servlet.UsefulServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * Created by lambor on 17-5-17.
 */
@HandlesTypes({UsefulServlet.class})
public class MyServletContainerInitializer implements javax.servlet.ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("onStartup");
        ServletRegistration registration = servletContext.addServlet("usefulServlet","servlet.UsefulServlet");
        registration.addMapping("/app14a/useful");
        System.out.println("leaving onStartup");
    }
}
