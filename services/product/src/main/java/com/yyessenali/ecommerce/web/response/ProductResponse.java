package com.yyessenali.ecommerce.web.response;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductResponse {
	private long id;
	private String name;
	private String description;
	private double availableQuantity;
	private BigDecimal price;
	private int categoryId;
	private String categoryName;
	private String categoryDescription;
}
