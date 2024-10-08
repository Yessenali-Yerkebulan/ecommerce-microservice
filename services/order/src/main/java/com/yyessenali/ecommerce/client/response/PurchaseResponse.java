package com.yyessenali.ecommerce.client.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseResponse {
	private long productId;
	private String name;
	private String description;
	private BigDecimal price;
	private double quantity;
}
