package com.yyessenali.ecommerce.service;

import com.yyessenali.ecommerce.web.request.OrderRequest;

import jakarta.validation.Valid;

public interface OrderService {

	Long createOrder(@Valid OrderRequest request);

}
