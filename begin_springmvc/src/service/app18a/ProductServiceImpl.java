package service.app18a;

import app17a.domain.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lambor on 17-5-18.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private Map<Long,Product> products = new HashMap<>();
    private AtomicLong generator = new AtomicLong();

    public ProductServiceImpl() {
        Product product = new Product();
        product.setName("JX1 Power Drill");
        product.setDescription("Powerful hand drill, made to perfection");
        product.setPrice(129.99f);
        add(product);
    }

    @Override
    public Product add(Product product) {
        long newId = generator.incrementAndGet();
        product.setId(newId);
        products.put(newId,product);
        return product;
    }

    @Override
    public Product get(long id) {
        return products.get(id);
    }
}
