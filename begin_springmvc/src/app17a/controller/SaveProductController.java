package app17a.controller;


import app17a.domain.Product;
import app17a.form.ProductForm;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lambor on 17-5-17.
 */
public class SaveProductController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ProductForm productForm = new ProductForm();
        productForm.setName(req.getParameter("name"));
        productForm.setDescription(req.getParameter("description"));
        productForm.setPrice(req.getParameter("price"));

        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(product.getDescription());
        product.setPrice(Float.parseFloat(productForm.getPrice()));
//        return new ModelAndView("/WEB-INF/jsp/ProductDetails.jsp","product",product);
        return new ModelAndView("ProductDetails","product",product);
    }
}
