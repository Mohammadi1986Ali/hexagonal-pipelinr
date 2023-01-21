package com.javalab.tutorial.hp.adapter;

import com.javalab.tutorial.hp.dto.Product;
import com.javalab.tutorial.hp.entity.ProductEntity;
import com.javalab.tutorial.hp.mapper.ProductMapper;
import com.javalab.tutorial.hp.repository.ProductRepository;
import com.javalab.tutorial.hp.spi.ProductPersistence;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductJpaAdapter implements ProductPersistence {

    private final ProductMapper mapper;
    private final ProductRepository repository;

    public ProductJpaAdapter(ProductMapper mapper, ProductRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Product addProduct(Product product) {
        ProductEntity savedProduct = repository.save(mapper.map(product));
        return mapper.map(savedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        ProductEntity updatedProduct = repository.save(mapper.map(product));
        return mapper.map(updatedProduct);
    }

    @Override
    public List<Product> getProducts() {
        return mapper.map(repository.findAll());
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return repository.findById(id).map(mapper::map);
    }
}
