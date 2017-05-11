package app11a;

import javax.servlet.AsyncContext;
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
        name = "AsyncDispatchServlet",
        urlPatterns = {"/app11a/asyncDispatch"},
        asyncSupported = true
)
public class AsyncDispatchServlet extends HttpServlet {
    private static final long serialVersionUID = 222L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync();
        req.setAttribute("mainThread",Thread.currentThread().getName());
        asyncContext.setTimeout(5000);
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                req.setAttribute("workerThread",Thread.currentThread().getName());
                asyncContext.dispatch("/app11a/threadNames.jsp");
            }
        });
    }
}
