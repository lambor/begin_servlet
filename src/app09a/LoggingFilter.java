package app09a;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by lambor on 17-5-9.
 *
 */
@WebFilter(
        filterName = "LoggingFilter",
        urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name = "logFileName", value = "log.txt"),
                @WebInitParam(name = "prefix", value="URI: ")
        }
        , asyncSupported = true
)
public class LoggingFilter implements Filter {

    private PrintWriter logger;
    private String prefix;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        prefix = filterConfig.getInitParameter("prefix");
        String logFileName = filterConfig.getInitParameter("logFileName");
        String appPath = filterConfig.getServletContext().getRealPath("/");

        try {
            File file = new File(appPath,logFileName);
            System.out.println("LoggingFilter init. log file:" + file.getAbsolutePath());
            logger = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LoggingFilter.doFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        logger.println(new Date() + " " + prefix + httpServletRequest.getRequestURI());
        logger.flush();
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroying filter");
        if(logger != null) {
            logger.close();
        }
    }
}
