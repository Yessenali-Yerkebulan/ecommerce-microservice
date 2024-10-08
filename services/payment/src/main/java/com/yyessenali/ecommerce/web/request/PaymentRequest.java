package com.yyessenali.ecommerce.web.request;

import java.math.BigDecimal;

import com.yyessenali.ecommerce.model.PaymentMethod;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaymentRequest {
	private long id;
	private BigDecimal amount;
	private PaymentMethod paymentMethod;
	private long orderId;
	private String orderReference;
	private Customer customer;
}
