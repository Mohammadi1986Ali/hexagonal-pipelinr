package com.javalab.tutorial.hp.config;

import com.javalab.tutorial.hp.api.ProductService;
import com.javalab.tutorial.hp.service.ProductServiceImpl;
import com.javalab.tutorial.hp.spi.ProductPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    private final ProductPersistence persistence;

    public ProductConfig(ProductPersistence persistence) {
        this.persistence = persistence;
    }

    @Bean
    ProductService productService() {
        return new ProductServiceImpl(persistence);
    }
}
