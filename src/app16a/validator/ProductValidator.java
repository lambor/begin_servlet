package app16a.validator;

import app16a.form.ProductForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lambor on 17-5-17.
 */
public class ProductValidator {
    public List<String> validate(ProductForm productForm) {
        List<String> errors = new ArrayList<>();
        String name = productForm.getName();
        if(name == null || name.trim().isEmpty()) {
            errors.add("Product must have a name");
        }
        String price = productForm.getPrice();
        if(price == null || price.trim().isEmpty()) {
            errors.add("Product must have a price");
        } else {
            try {
                Float.parseFloat(price);
            } catch (NumberFormatException e) {
                errors.add("Invalid price value");
            }
        }
        return errors;
    }
}
