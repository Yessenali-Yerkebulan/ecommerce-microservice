package com.yyessenali.ecommerce.kafka.order;

import java.math.BigDecimal;
import java.util.List;

import com.yyessenali.ecommerce.kafka.payment.PaymentMethod;

import lombok.Data;

@Data
public class OrderConfirmation {
	private String orderReference;
	private BigDecimal totalAmount;
	private PaymentMethod paymentMethod;
	private Customer customer;
	private List<Product> products;
}
