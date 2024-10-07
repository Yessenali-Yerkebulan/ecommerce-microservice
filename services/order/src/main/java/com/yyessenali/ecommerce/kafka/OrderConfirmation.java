package com.yyessenali.ecommerce.kafka;

import java.math.BigDecimal;
import java.util.List;

import com.yyessenali.ecommerce.client.response.CustomerResponse;
import com.yyessenali.ecommerce.client.response.PurchaseResponse;
import com.yyessenali.ecommerce.model.PaymentMethod;

import lombok.Builder;

@Builder
public class OrderConfirmation {
	private String orderReference;
	private BigDecimal totalAmount;
	private PaymentMethod paymentMethod;
	private CustomerResponse customer;
	private List<PurchaseResponse> products;
}
