package controller.app22a;

import app21a.domain.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import validator.ProductValidator;

/**
 * Created by lambor on 17-5-20.
 */
@Controller(
        value = "app22a.ProductController"
)
@RequestMapping("/app22a/*")
public class ProductController {
    private static final Log logger = LogFactory.getLog(ProductController.class);

    @RequestMapping("/product_input")
    public String inputProduct(Model model) {
        model.addAttribute("product",new Product());
        return "ProductForm22_2";
    }

    @RequestMapping("/product_save")
    public String saveProduct(@ModelAttribute Product product, BindingResult bindingResult,Model model) {
        ProductValidator productValidator = new ProductValidator();
        productValidator.validate(product,bindingResult);
        if(bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            logger.info("Code:"+fieldError.getCode() + ", field:" + fieldError.getField());
            return "ProductForm";
        }
        model.addAttribute("product",product);
        return "ProductDetails";
    }
}
