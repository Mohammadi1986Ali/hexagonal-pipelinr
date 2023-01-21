package com.javalab.tutorial.hp.resources;

import com.javalab.tutorial.hp.api.ProductService;
import com.javalab.tutorial.hp.dto.Product;
import com.javalab.tutorial.hp.event.CreateProduct;
import com.javalab.tutorial.hp.event.Events;
import com.javalab.tutorial.hp.generated.v1.api.ProductsApi;
import com.javalab.tutorial.hp.generated.v1.model.ProductRequest;
import com.javalab.tutorial.hp.generated.v1.model.ProductResponse;
import com.javalab.tutorial.hp.mapper.ProductModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductResource implements ProductsApi{

    private final ProductService service;
    private final ProductModelMapper mapper;
    private final Events events;

    public ProductResource(ProductService service, ProductModelMapper mapper, Events events) {
        this.service = service;
        this.mapper = mapper;
        this.events = events;
    }

    @Override
    public ResponseEntity<ProductResponse> addProduct(ProductRequest productRequest) {
        var savedProduct = events.publish(CreateProduct.builder().product(mapper.map(productRequest)).build());
        return ResponseEntity.ok(mapper.map(savedProduct));
        /**
         * By using these line we can create product instead of using event (Event Driven Design).
         * Product savedProduct = service.addProduct(mapper.map(productRequest));
         * return ResponseEntity.ok(mapper.map(savedProduct));
         */
    }

    @Override
    public ResponseEntity<List<ProductResponse>> getProducts() {
        List<Product> products = service.getProducts();
        return  ResponseEntity.ok(mapper.map(products));
    }
}
