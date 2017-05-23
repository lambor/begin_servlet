package controller.app24b;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * Created by lambor on 17-5-23.
 */
@Controller
public class ImageController {

    private static final Log logger = LogFactory.getLog(ImageController.class);

    @RequestMapping(value = "/image_get/{id}",method = RequestMethod.GET)
    public void getImage(@PathVariable String id,
                         HttpServletRequest req, HttpServletResponse resp,
                         @RequestHeader(name = "Referer") String referer) {
        if(referer != null) {

            String imageDirectory = req.getServletContext().getRealPath("/WEB-INF/image");
            File file = new File(imageDirectory,id+".jpg");
            if(file.exists()) {
                resp.setContentType("image/jpg");
                try(
                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                        OutputStream os = resp.getOutputStream();
                ) {
                    byte[] buffer = new byte[1024];
                    int i = bis.read(buffer);
                    while(i != -1) {
                        os.write(buffer,0,i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
