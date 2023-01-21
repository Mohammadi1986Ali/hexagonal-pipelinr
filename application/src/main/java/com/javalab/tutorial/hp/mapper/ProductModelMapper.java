package com.javalab.tutorial.hp.mapper;

import com.javalab.tutorial.hp.dto.Product;
import com.javalab.tutorial.hp.generated.v1.model.ProductRequest;
import com.javalab.tutorial.hp.generated.v1.model.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductModelMapper {
    Product map(ProductRequest productRequest);
    ProductResponse map (Product product);

    List<ProductResponse> map(List<Product> products);
}
