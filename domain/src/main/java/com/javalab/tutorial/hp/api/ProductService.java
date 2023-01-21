package com.javalab.tutorial.hp.api;

import com.javalab.tutorial.hp.dto.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product addProduct(Product product);
    void deleteProduct(Long id);
    Product updateProduct(Product product);
    List<Product> getProducts();
    Optional<Product> getProductById(Long id);
}
