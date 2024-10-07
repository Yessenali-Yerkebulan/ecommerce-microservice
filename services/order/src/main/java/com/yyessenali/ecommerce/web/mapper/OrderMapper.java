package com.yyessenali.ecommerce.web.mapper;

import org.springframework.stereotype.Component;

import com.yyessenali.ecommerce.model.Order;
import com.yyessenali.ecommerce.web.request.OrderRequest;
import com.yyessenali.ecommerce.web.response.OrderResponse;

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
	
	public OrderResponse toOrderResponse(Order order) {
		return OrderResponse.builder()
				.id(order.getId())
				.reference(order.getReference())
				.amount(order.getTotalAmount())
				.paymentMethod(order.getPaymentMethod())
				.customerId(order.getCustomerId())
				.build();
	}
}
