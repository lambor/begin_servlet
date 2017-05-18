package service.app18a;

import app17a.domain.Product;

/**
 * Created by lambor on 17-5-18.
 */
public interface ProductService {
    Product add(Product product);
    Product get(long id);
}
