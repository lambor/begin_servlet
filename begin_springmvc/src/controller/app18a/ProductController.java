package controller.app18a;

import app17a.domain.Product;
import app17a.form.ProductForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.app18a.ProductService;

/**
 * Created by lambor on 17-5-18.
 *
 * 关于 controller 方法所接受的参数
 * http://www.jianshu.com/p/ed44e89a6f79
 */
@Controller
public class ProductController {
    private static final Log logger = LogFactory.getLog(ProductController.class);

    /**
     * ch18.3
     */

    @RequestMapping("/app18a/product_input")
    public String inputProduct() {
        logger.info("inputProduct called");
        return "ProductForm18";
    }

    @RequestMapping(value = "/app18a/product_save",method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute ProductForm productForm, Model model) {
        logger.info("saveProduct called");


        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        product.setPrice(Float.parseFloat(productForm.getPrice()));
        model.addAttribute("product",product);

        return "ProductDetails";
    }


    /**
     * ch18.4
     */

    @Autowired
    private ProductService productService;

    @RequestMapping("/app18a/product_input2")
    public String inputProduct2() {
        logger.info("inputProduct called");
        return "ProductForm18_2";
    }

    @RequestMapping(value = "/app18a/product_save2",method = RequestMethod.POST)
    public String saveProduct2(ProductForm productForm, RedirectAttributes redirectAttributes) {
        logger.info("saveProduct called");

        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        product.setPrice(Float.parseFloat(productForm.getPrice()));
        Product savedProduct = productService.add(product);

        redirectAttributes.addFlashAttribute("message","The product was successfully added.");
        return "redirect:product_view/"+savedProduct.getId();
    }

    @RequestMapping(value = "/app18a/product_view/{id}")
    public String viewProduct(@PathVariable Long id,Model model) {
        Product product = productService.get(id);
        model.addAttribute("product",product);
        return "ProductView";
    }

    static class Test {
        String teststr;

        public Test() {
        }

        public void setTeststr(String teststr) {
            this.teststr = teststr;
        }

        public String getTeststr() {
            return teststr;
        }
    }

    @RequestMapping(value = "/app18a/test")
    public void test(Test test) {
        logger.info(test.teststr);
    }
}
