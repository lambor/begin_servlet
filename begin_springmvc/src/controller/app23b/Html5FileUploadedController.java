package controller.app23b;

import app23b.domain.UploadedFile;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by lambor on 17-5-22.
 */
@Controller
@RequestMapping(value = {"/app23b/*"})
public class Html5FileUploadedController {
    private static final Log logger = LogFactory.getLog(Html5FileUploadedController.class);

    @RequestMapping(value = {"/html5"})
    public String inputProduct() {
        return "html5";
    }

    @RequestMapping(value = {"/file_upload"})
    public void saveFile(HttpServletRequest req, @ModelAttribute UploadedFile uploadedFile,
                         BindingResult bindingResult,Model model) {
        MultipartFile multipartFile = uploadedFile.getMultipartFile();
        String fileName = multipartFile.getOriginalFilename();
        File fileDir = new File(req.getServletContext().getRealPath("/files"));
        if(!fileDir.exists())
            fileDir.mkdir();
        try {
            File file = new File(fileDir.getAbsolutePath(),fileName);
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
