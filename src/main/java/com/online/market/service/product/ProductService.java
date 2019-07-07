package com.online.market.service.product;

import com.online.market.model.product.Product;
import com.online.market.repository.product.ProductRepository;
import com.online.market.service.exception.OnlineMarketServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private final ProductRepository productRepository;

    public Product get(final long id) {
        return productRepository.findById(id).orElseThrow(() -> new OnlineMarketServiceException("Entity not found"));
    }

    public Product create(final String name) {
        checkIfUnique(name);
        final Product product = new Product();
        product.setName(name);
        return productRepository.save(product);
    }

    public Product update(final long id, final String name) {
        checkIfUnique(name);
        final Product product = get(id);
        product.setName(name);
        return productRepository.save(product);
    }

    private void checkIfUnique(String name) {
        Assert.notNull(name, "Product name cannot be null");
        if (productRepository.getByName(name).isPresent()) {
            throw new OnlineMarketServiceException("Product with name " + name + " already exists");
        }
    }

}
