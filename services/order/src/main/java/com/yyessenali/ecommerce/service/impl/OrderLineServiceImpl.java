package com.yyessenali.ecommerce.service.impl;

import org.springframework.stereotype.Service;

import com.yyessenali.ecommerce.repository.OrderLineRepository;
import com.yyessenali.ecommerce.service.OrderLineService;
import com.yyessenali.ecommerce.web.mapper.OrderLineMapper;
import com.yyessenali.ecommerce.web.request.OrderLineRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {
	
	private final OrderLineRepository repository;
	private final OrderLineMapper mapper;
	
	@Override
	public Long saveOrderLine(OrderLineRequest orderLineRequest) {
		var order = mapper.toOrderLine(orderLineRequest);
		return repository.save(order).getId();
	}

}
