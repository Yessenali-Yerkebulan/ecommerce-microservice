package com.yyessenali.ecommerce.web.mapper;

import org.springframework.stereotype.Component;

import com.yyessenali.ecommerce.model.Order;
import com.yyessenali.ecommerce.model.OrderLine;
import com.yyessenali.ecommerce.web.request.OrderLineRequest;

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

}
