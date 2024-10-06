package com.yyessenali.ecommerce.web.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductRequest {
	private long id;
	@NotNull(message = "Product name is required")
	private String name;
	@NotNull(message = "Product description is required")
	private String description;
	@Positive(message = "Available quantity should be positive")
	private double availableQuantity;
	@Positive(message = "Price should be positive")
	private BigDecimal price;
	@NotNull(message = "Product category is required")
	private int categoryId;
}
