package com.yyessenali.ecommerce.kafka.payment;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PaymentConfirmation {
	private String orderReference;
	private BigDecimal amount;
	private PaymentMethod paymentMethod;
	private String customerFirstname;
	private String customerLastname;
	private String customerEmail;
}
