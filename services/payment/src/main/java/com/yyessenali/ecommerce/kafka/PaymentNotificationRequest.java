package com.yyessenali.ecommerce.kafka;

import java.math.BigDecimal;

import com.yyessenali.ecommerce.model.PaymentMethod;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentNotificationRequest {
	private String orderReference;
	private BigDecimal amount;
	private PaymentMethod paymentMethod;
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
}
