package controller.app24a;

import app24a.domain.Login;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * Created by lambor on 17-5-23.
 */
@Controller
@RequestMapping("/app24a/*")
public class ResourceController {
    private static final Log logger = LogFactory.getLog(ResourceController.class);

    @RequestMapping("/login")
    public String login(@ModelAttribute Login login, HttpSession session, Model model) {
        model.addAttribute("login",new Login());
        if("Paul".equals(login.getUserName()) && "secret".equals(login.getPassword())) {
            session.setAttribute("loggedIn",Boolean.TRUE);
            return "Main";
        } else {
            return "LoginForm";
        }
    }

    @RequestMapping("/resource_download")
    public String downloadResource(HttpSession session, HttpServletRequest req, HttpServletResponse resp, Model model) {
        if(session == null || session.getAttribute("loggedIn") == null) {
            model.addAttribute("login",new Login());
            return "LoginForm";
        }
        String dataDirectory = req.getServletContext().getRealPath("/WEB-INF/data");
//        String dataDirectory = "/home/lambor";
        File file = new File(dataDirectory,"secret.pdf");
        if(file.exists()) {
            resp.setContentType("application/pdf");
            resp.addHeader("Content-Disposition","attachment; filename=secret.pdf");
            try(
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                    OutputStream os = resp.getOutputStream();
            ) {
                byte[] buffer = new byte[1024];
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer,0,i);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
