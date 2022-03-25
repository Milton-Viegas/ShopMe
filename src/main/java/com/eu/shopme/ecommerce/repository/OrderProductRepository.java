package com.eu.shopme.ecommerce.repository;

import com.eu.shopme.ecommerce.model.OrderProduct;
import com.eu.shopme.ecommerce.model.OrderProductPK;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}