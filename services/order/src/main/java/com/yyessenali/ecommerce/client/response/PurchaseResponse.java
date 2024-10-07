package com.yyessenali.ecommerce.client.response;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchaseResponse {
	private long productId;
	private String name;
	private String description;
	private BigDecimal price;
	private double quantity;
}
