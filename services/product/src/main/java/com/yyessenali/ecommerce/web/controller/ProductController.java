package com.yyessenali.ecommerce.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyessenali.ecommerce.service.ProductService;
import com.yyessenali.ecommerce.web.request.ProductPurchaseRequest;
import com.yyessenali.ecommerce.web.request.ProductRequest;
import com.yyessenali.ecommerce.web.response.ProductPurchaseResponse;
import com.yyessenali.ecommerce.web.response.ProductResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService service;
	
	@PostMapping
	public ResponseEntity<Long> createProduct(
			@RequestBody @Valid ProductRequest request
	) {
		return ResponseEntity.ok(service.createProduct(request));
	}
	
	@PostMapping("/purchase")
	public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
			@RequestBody List<ProductPurchaseRequest> request
	) {
		return ResponseEntity.ok(service.purchaseProducts(request));
	}
	
	@GetMapping("/{product-id}")
	public ResponseEntity<ProductResponse> findById(@PathVariable("product-id") long productId) {
		return ResponseEntity.ok(service.findById(productId));
	}
	
	@GetMapping
	public ResponseEntity<List<ProductResponse>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
}
