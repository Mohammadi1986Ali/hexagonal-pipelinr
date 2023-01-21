package com.javalab.tutorial.hp.mapper;

import com.javalab.tutorial.hp.dto.Product;
import com.javalab.tutorial.hp.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    Product map(ProductEntity productEntity);
    ProductEntity map(Product product);
    List<Product> map(List<ProductEntity> productEntities);
}
