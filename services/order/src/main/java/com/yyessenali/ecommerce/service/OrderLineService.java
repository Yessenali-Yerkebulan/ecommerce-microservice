package com.yyessenali.ecommerce.service;

import java.util.List;

import com.yyessenali.ecommerce.web.request.OrderLineRequest;
import com.yyessenali.ecommerce.web.response.OrderLineResponse;

public interface OrderLineService {

	Long saveOrderLine(OrderLineRequest orderLineRequest);

	List<OrderLineResponse> findAllByOrderId(long orderId);

}
