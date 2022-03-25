package com.eu.shopme.ecommerce.repository;

import com.eu.shopme.ecommerce.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}