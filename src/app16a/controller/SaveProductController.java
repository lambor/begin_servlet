package app16a.controller;

import app16a.domain.Product;
import app16a.form.ProductForm;
import app16a.validator.ProductValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lambor on 17-5-17.
 */
public class SaveProductController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        ProductForm productForm = new ProductForm();
        productForm.setName(req.getParameter("name"));
        productForm.setDescription(req.getParameter("description"));
        productForm.setPrice(req.getParameter("price"));

        ProductValidator productValidator = new ProductValidator();
        List<String> errors = productValidator.validate(productForm);
        if(errors.isEmpty()) {
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(product.getDescription());
            product.setPrice(Float.parseFloat(productForm.getPrice()));
            req.setAttribute("product", product);
            return "/WEB-INF/jsp/ProductDetails.jsp";
        } else {
            req.setAttribute("errors",errors);
            req.setAttribute("form",productForm);
            return "/WEB-INF/jsp/ProductForm.jsp";
        }
    }
}
