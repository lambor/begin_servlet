package app11a;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lambor on 17-5-11.
 */
@WebServlet(
        name = "AsyncListenerServlet",
        urlPatterns = {"/asyncListener"},
        asyncSupported = true
)
public class AsyncListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(5000);
        asyncContext.addListener(new MyAsyncListener());
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String greeting = "hi from listener";
                System.out.println("wait...");
                req.setAttribute("greeting",greeting);
                asyncContext.dispatch("/app11a/test.jsp");
            }
        });
    }
}
