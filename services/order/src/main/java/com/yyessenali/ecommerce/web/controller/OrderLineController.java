package com.yyessenali.ecommerce.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyessenali.ecommerce.service.OrderLineService;
import com.yyessenali.ecommerce.web.response.OrderLineResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order-lines")
public class OrderLineController {
	private final OrderLineService service;
	
	@GetMapping("/order/{order-id}")
	public ResponseEntity<List<OrderLineResponse>> findByOrderId(
			@PathVariable("order-id") long orderId
		) {
		return ResponseEntity.ok(service.findAllByOrderId(orderId));
	}
}
