package com.yyessenali.ecommerce.service.impl;

import org.springframework.stereotype.Service;

import com.yyessenali.ecommerce.kafka.NotificationProducer;
import com.yyessenali.ecommerce.kafka.PaymentNotificationRequest;
import com.yyessenali.ecommerce.repository.PaymentRepository;
import com.yyessenali.ecommerce.service.PaymentService;
import com.yyessenali.ecommerce.web.mapper.PaymentMapper;
import com.yyessenali.ecommerce.web.request.PaymentRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
	
	private final PaymentRepository repository;
	private final PaymentMapper mapper;
	private final NotificationProducer notificationProducer;
	
	@Override
	public Long createPayment(@Valid PaymentRequest request) {
		var payment = repository.save(mapper.toPayment(request));
		
		notificationProducer.sendNotification(
				PaymentNotificationRequest.builder()
					.orderReference(request.getOrderReference())
					.amount(request.getAmount())
					.paymentMethod(request.getPaymentMethod())
					.customerFirstname(request.getCustomer().getFirstname())
					.customerLastname(request.getCustomer().getLastname())
					.customerEmail(request.getCustomer().getEmail())
					.build()
		);
		
		return payment.getId();
	}

}
