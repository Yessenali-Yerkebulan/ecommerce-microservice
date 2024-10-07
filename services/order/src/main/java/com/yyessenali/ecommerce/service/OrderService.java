package com.yyessenali.ecommerce.service;

import java.util.List;

import com.yyessenali.ecommerce.web.request.OrderRequest;
import com.yyessenali.ecommerce.web.response.OrderResponse;

import jakarta.validation.Valid;

public interface OrderService {

	Long createOrder(@Valid OrderRequest request);

	List<OrderResponse> findAll();

	OrderResponse findById(long orderId);

}
