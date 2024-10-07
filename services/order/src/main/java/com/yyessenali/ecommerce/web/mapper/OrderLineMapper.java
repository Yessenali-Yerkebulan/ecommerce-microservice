package com.yyessenali.ecommerce.web.mapper;

import org.springframework.stereotype.Component;

import com.yyessenali.ecommerce.model.Order;
import com.yyessenali.ecommerce.model.OrderLine;
import com.yyessenali.ecommerce.web.request.OrderLineRequest;
import com.yyessenali.ecommerce.web.response.OrderLineResponse;

@Component
public class OrderLineMapper {

	public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
		return OrderLine.builder()
				.id(orderLineRequest.getId())
				.quantity(orderLineRequest.getQuantity())
				.order(
					Order.builder()
						.id(orderLineRequest.getOrderId())
						.build()
				)
				.productId(orderLineRequest.getProductId())
				.build();
	}

	public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
		return OrderLineResponse.builder()
				.id(orderLine.getId())
				.quantity(orderLine.getQuantity())
				.build();
	}
}
