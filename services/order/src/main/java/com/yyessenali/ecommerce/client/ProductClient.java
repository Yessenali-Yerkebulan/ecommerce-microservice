package com.yyessenali.ecommerce.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yyessenali.ecommerce.client.response.PurchaseResponse;
import com.yyessenali.ecommerce.web.request.PurchaseRequest;

@FeignClient(
		name = "product-service",
		url = "${application.config.product-url}"
)
public interface ProductClient {
	@PostMapping("/purchase")
	List<PurchaseResponse> purchaseProducts(@RequestBody List<PurchaseRequest> requestBody);
}
