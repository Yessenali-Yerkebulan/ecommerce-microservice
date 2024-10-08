package com.yyessenali.ecommerce.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yyessenali.ecommerce.web.request.PaymentRequest;

@FeignClient(
		name = "product-service",
		url = "${application.config.payment-url}"
)
public interface PaymentClient {
	@PostMapping
	Long requestOrderPayment(@RequestBody PaymentRequest request);
}
