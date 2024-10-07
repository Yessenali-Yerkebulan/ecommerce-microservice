package com.yyessenali.ecommerce.service.impl;

import org.springframework.stereotype.Service;

import com.yyessenali.ecommerce.client.CustomerClient;
import com.yyessenali.ecommerce.client.ProductClient;
import com.yyessenali.ecommerce.exception.BusinessException;
import com.yyessenali.ecommerce.repository.OrderRepository;
import com.yyessenali.ecommerce.service.OrderLineService;
import com.yyessenali.ecommerce.service.OrderService;
import com.yyessenali.ecommerce.web.mapper.OrderMapper;
import com.yyessenali.ecommerce.web.request.OrderLineRequest;
import com.yyessenali.ecommerce.web.request.OrderRequest;
import com.yyessenali.ecommerce.web.request.PurchaseRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
	
	private final CustomerClient customerClient;
	private final ProductClient productClient;
	private final OrderRepository orderRepository;
	private final OrderMapper mapper;
	private final OrderLineService orderLineService;
	
	@Override
	public Long createOrder(@Valid OrderRequest request) {
		var customer = customerClient.findCustomerById(request.getCustomerId())
				.orElseThrow(() -> new BusinessException("Cannot create order :: No Customer exists with the provided ID"));
		
		productClient.purchaseProducts(request.getProducts());
		
		var order = orderRepository.save(mapper.toOrder(request));
		
		for(PurchaseRequest purchaseRequest : request.getProducts()) {
			orderLineService.saveOrderLine(
					OrderLineRequest.builder()
					.id(null)
					.orderId(order.getId())
					.productId(purchaseRequest.getProductId())
					.quantity(purchaseRequest.getQuantity())
					.build()
			);
		}
		
		return null;
	}

}
