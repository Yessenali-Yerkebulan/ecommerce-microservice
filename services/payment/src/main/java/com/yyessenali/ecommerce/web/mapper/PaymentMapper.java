package com.yyessenali.ecommerce.web.mapper;

import org.springframework.stereotype.Component;

import com.yyessenali.ecommerce.model.Payment;
import com.yyessenali.ecommerce.web.request.PaymentRequest;

import jakarta.validation.Valid;

@Component
public class PaymentMapper {

	public Payment toPayment(@Valid PaymentRequest request) {
		return Payment.builder()
				.id(request.getId())
				.orderId(request.getOrderId())
				.paymentMethod(request.getPaymentMethod())
				.amount(request.getAmount())
				.build();
	}

}
