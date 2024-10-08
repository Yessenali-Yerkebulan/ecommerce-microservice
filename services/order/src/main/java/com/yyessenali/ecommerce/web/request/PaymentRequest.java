package com.yyessenali.ecommerce.web.request;

import java.math.BigDecimal;

import com.yyessenali.ecommerce.client.response.CustomerResponse;
import com.yyessenali.ecommerce.model.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
	private BigDecimal amount;
	private PaymentMethod paymentMethod;
	private long orderId;
	private String orderReference;
	private CustomerResponse customer;
}
