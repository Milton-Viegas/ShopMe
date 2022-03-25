package com.eu.shopme.ecommerce.service;

import com.eu.shopme.ecommerce.model.Order;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderService {

    @NotNull Iterable<Order> getAllOrders();

    Order create(@NotNull(message = "O pedido não pode ser nulo.") @Valid Order order);

    void update(@NotNull(message = "O pedido não pode ser nulo.") @Valid Order order);
}
