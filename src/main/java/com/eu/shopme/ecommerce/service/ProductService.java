package com.eu.shopme.ecommerce.service;

import com.eu.shopme.ecommerce.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "ID de produto inválido!.") long id);

    Product save(Product product);
}