package validator;

import app21a.domain.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;

/**
 * Created by lambor on 17-5-20.
 */
public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;
        ValidationUtils.rejectIfEmpty(errors,"name","productname.required");
        ValidationUtils.rejectIfEmpty(errors,"price","price.required");
        ValidationUtils.rejectIfEmpty(errors,"productionDate","productiondate.required");
        Float price = product.getPrice();
        if(price != null && price < 0) {
            errors.rejectValue("price","price.negative");
        }
        Date productionDate = product.getProductionDate();
        if(productionDate != null) {
            if(productionDate.after(new Date())) {
                System.out.println("salah lagi");
                errors.rejectValue("productionDate", "productiondate.invalid");
            }
        }
    }
}
