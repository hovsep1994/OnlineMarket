package com.online.market.controller.product;


import com.online.market.controller.common.OrikaBeanMapper;
import com.online.market.model.product.Product;
import com.online.market.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private final ProductService productService;
    private final OrikaBeanMapper mapper;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductResponse get(@PathVariable long id) {
        return mapper.map(productService.get(id), ProductResponse.class);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ProductResponse create(@RequestBody final ProductRequest request) {
        final Product product = productService.create(request.getName());
        return mapper.map(product, ProductResponse.class);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ProductResponse create(@PathVariable long id, @RequestBody final ProductRequest request) {
        final Product product = productService.update(id, request.getName());
        return mapper.map(product, ProductResponse.class);
    }

}
