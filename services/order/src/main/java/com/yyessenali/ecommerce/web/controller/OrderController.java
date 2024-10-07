package com.yyessenali.ecommerce.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyessenali.ecommerce.service.OrderService;
import com.yyessenali.ecommerce.web.request.OrderRequest;
import com.yyessenali.ecommerce.web.response.OrderResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
	private final OrderService service;
	
	@PostMapping
	public ResponseEntity<Long> createOrder(
			@RequestBody @Valid OrderRequest request
	) {
		return ResponseEntity.ok(service.createOrder(request));
	}
	
	@GetMapping
	public ResponseEntity<List<OrderResponse>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{order-id}")
	public ResponseEntity<OrderResponse> findById(@PathVariable("order-id") long orderId) {
		return ResponseEntity.ok(service.findById(orderId));
	}
}
