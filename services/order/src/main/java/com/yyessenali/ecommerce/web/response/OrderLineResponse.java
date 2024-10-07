package com.yyessenali.ecommerce.web.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderLineResponse {
	private long id;
	private double quantity;
}
