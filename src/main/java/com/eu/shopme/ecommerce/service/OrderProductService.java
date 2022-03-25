package com.eu.shopme.ecommerce.service;

import com.eu.shopme.ecommerce.model.OrderProduct;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderProductService {

    OrderProduct create(@NotNull(message = "O pedido de produtos não pode ser nulo.") @Valid OrderProduct orderProduct);
}
