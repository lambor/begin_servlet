package controller.app21b;

import app21b.domain.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.xml.datatype.DatatypeConstants;

/**
 * Created by lambor on 17-5-22.
 */

@Controller("app21b.ProductController")
public class ProductController {
    private static final Log logger = LogFactory.getLog(controller.app21a.ProductController.class);

    @RequestMapping("/app21b/product_input")
    public String inputProduct(Model model) {
        model.addAttribute("product",new Product());
        return "ProductForm";
    }

    @RequestMapping("/app21b/product_save")
    public String saveProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            logger.info("Code:" + fieldError.getCode()
                    + ", object:" + fieldError.getObjectName()
                    + ", field:" + fieldError.getField());
            return "ProductForm";
        }
        model.addAttribute(product);
        return "ProductDetails";
    }
}
