package com.eu.shopme.ecommerce.repository;

import com.eu.shopme.ecommerce.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
