package com.javalab.tutorial.hp.service;

import com.javalab.tutorial.hp.api.ProductService;
import com.javalab.tutorial.hp.dto.Product;
import com.javalab.tutorial.hp.spi.ProductPersistence;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private final ProductPersistence persistence;

    public ProductServiceImpl(ProductPersistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public Product addProduct(Product product) {
        return persistence.addProduct(product);
    }

    @Override
    public void deleteProduct(Long id) {
        persistence.deleteProduct(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return persistence.updateProduct(product);
    }

    @Override
    public List<Product> getProducts() {
        return persistence.getProducts();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return persistence.getProductById(id);
    }
}
