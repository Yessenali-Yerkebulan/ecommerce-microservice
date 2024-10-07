package com.yyessenali.ecommerce.service;

import com.yyessenali.ecommerce.web.request.OrderLineRequest;

public interface OrderLineService {

	Long saveOrderLine(OrderLineRequest orderLineRequest);

}
