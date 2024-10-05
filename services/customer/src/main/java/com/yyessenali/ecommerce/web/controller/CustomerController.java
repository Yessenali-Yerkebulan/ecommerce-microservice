package com.yyessenali.ecommerce.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyessenali.ecommerce.service.CustomerService;
import com.yyessenali.ecommerce.web.request.CustomerRequest;
import com.yyessenali.ecommerce.web.response.CustomerResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
	private final CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest customerDto) {
		return ResponseEntity.ok(customerService.createCustomer(customerDto));
	}
	
	@PutMapping
	public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRequest customerDto) {
		customerService.updateCustomer(customerDto);
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerResponse>> findAll() {
		return ResponseEntity.ok(customerService.findAllCustomers());
	}
	
	@GetMapping("/exists/{customer-id}")
	public ResponseEntity<Boolean> existsById(@PathVariable("customer-id") String customerId) {
		return ResponseEntity.ok(customerService.existsById(customerId));
	}
	
	@GetMapping("/{customer-id}")
	public ResponseEntity<CustomerResponse> findById(@PathVariable("customer-id") String customerId) {
		return ResponseEntity.ok(customerService.findById(customerId));
	}
	
	@DeleteMapping("/{customer-id}")
	public ResponseEntity<Void> delete(
		@PathVariable("customer-id") String customerId
	) {
		customerService.deleteCustomer(customerId);
		return ResponseEntity.accepted().build();
	}
}
