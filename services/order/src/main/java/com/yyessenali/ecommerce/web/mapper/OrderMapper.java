package com.yyessenali.ecommerce.web.mapper;

import org.springframework.stereotype.Component;

import com.yyessenali.ecommerce.model.Order;
import com.yyessenali.ecommerce.web.request.OrderRequest;

@Component
public class OrderMapper {
	public Order toOrder(OrderRequest request) {
		return Order.builder()
				.id(request.getId())
				.customerId(request.getCustomerId())
				.reference(request.getReference())
				.totalAmount(request.getAmount())
				.paymentMethod(request.getPaymentMethod())
				.build();
	}
}
