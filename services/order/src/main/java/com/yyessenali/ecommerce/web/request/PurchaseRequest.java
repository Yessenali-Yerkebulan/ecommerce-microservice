package com.yyessenali.ecommerce.web.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PurchaseRequest {
	@NotNull(message = "Product is required")
	private long productId;
	@Positive(message = "Quantity is required")
	private double quantity;
}
