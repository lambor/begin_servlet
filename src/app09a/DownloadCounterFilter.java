package app09a;

import utils.Utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lambor on 17-5-9.
 */
@WebFilter(
        filterName = "DownloadCounterFilter",
        urlPatterns = {"/*"}
        , asyncSupported = true
)
public class DownloadCounterFilter implements Filter {

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Properties downloadLog;
    File logFile;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String appPath = filterConfig.getServletContext().getRealPath("/");
        logFile = new File(appPath, "downloadLog.txt");
        System.out.println("DownloadCounterFilter init. log file:" + logFile.getAbsolutePath());
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        downloadLog = new Properties();
        try {
            downloadLog.load(new FileReader(logFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        final String uri = httpServletRequest.getRequestURI();
        executorService.submit(() -> {
            int count = Optional.ofNullable(downloadLog.getProperty(uri))
                    .map(Utils::stringToInt).orElse(0);
            downloadLog.setProperty(uri,String.valueOf(count + 1));
            try {
                downloadLog.store(new FileWriter(logFile),"");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        executorService.shutdown();
    }
}
