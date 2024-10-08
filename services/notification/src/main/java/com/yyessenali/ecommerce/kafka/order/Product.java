package com.yyessenali.ecommerce.kafka.order;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private long productId;
	private String name;
	private String description;
	private BigDecimal price;
	private double quantity;
}
