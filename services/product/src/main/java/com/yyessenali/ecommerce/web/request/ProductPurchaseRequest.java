package com.yyessenali.ecommerce.web.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductPurchaseRequest {
	@NotNull(message = "ProductId can not be null")
	private long productId;
	@NotNull(message = "Product quantity can not be null")
	private double quantity;
}
