package com.javalab.tutorial.hp.event;

import com.javalab.tutorial.hp.dto.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProduct implements DomainEvent<Product> {

    private Product product;
}
