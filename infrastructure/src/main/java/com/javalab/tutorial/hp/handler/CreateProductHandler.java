package com.javalab.tutorial.hp.handler;

import an.awesome.pipelinr.Command;
import com.javalab.tutorial.hp.dto.Product;
import com.javalab.tutorial.hp.event.CreateProduct;
import com.javalab.tutorial.hp.mapper.ProductMapper;
import com.javalab.tutorial.hp.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateProductHandler implements Command.Handler<CreateProduct, Product> {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public CreateProductHandler(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Product handle(CreateProduct createProduct) {
        log.info("Create product: {}", createProduct.getProduct().getName());
        var savedProduct = repository.save(mapper.map(createProduct.getProduct()));
        return mapper.map(savedProduct);
    }
}
