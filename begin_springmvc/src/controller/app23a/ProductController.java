package controller.app23a;

import app23a.domain.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lambor on 17-5-22.
 */
@Controller("app23a.ProductController")
@RequestMapping("/app23a/*")
public class ProductController {
    private static final Log logger = LogFactory.getLog(ProductController.class);

    @RequestMapping("/product_input")
    public String inputProduct(Model model) {
        model.addAttribute("product", new Product());
        return "ProductForm23";
    }

    @RequestMapping("/product_save")
    public String saveProduct(
            HttpServletRequest req,
            @ModelAttribute @Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "ProductForm23";
        }

        List<MultipartFile> files = product.getImages();
        List<String> fileNames = new ArrayList<>();
        if (files != null && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
                File imageDir = new File(req.getServletContext().getRealPath("/images"));
                if(!imageDir.exists())
                    imageDir.mkdir();
                System.out.println(imageDir.getAbsolutePath());
                File imageFile = new File(imageDir.getAbsolutePath(),multipartFile.getOriginalFilename());
                try {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        model.addAttribute("product", product);
        return "ProductDetails23";
    }
}
