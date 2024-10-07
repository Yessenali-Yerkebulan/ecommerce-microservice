package com.yyessenali.ecommerce.web.response;

import java.math.BigDecimal;

import com.yyessenali.ecommerce.model.PaymentMethod;

import lombok.Builder;

@Builder
public class OrderResponse {
	private long id;
	private String reference;
	private BigDecimal amount;
	private PaymentMethod paymentMethod;
	private String customerId;
}
