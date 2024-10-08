package com.yyessenali.ecommerce.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyessenali.ecommerce.service.PaymentService;
import com.yyessenali.ecommerce.web.request.PaymentRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
	private final PaymentService service;
	
	@PostMapping
	public ResponseEntity<Long> createPayment(
			@RequestBody @Valid PaymentRequest request
	) {
		return ResponseEntity.ok(service.createPayment(request));
	}
}
