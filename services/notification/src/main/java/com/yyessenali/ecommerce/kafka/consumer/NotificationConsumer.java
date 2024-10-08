package com.yyessenali.ecommerce.kafka.consumer;

import java.time.LocalDateTime;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.yyessenali.ecommerce.kafka.order.OrderConfirmation;
import com.yyessenali.ecommerce.kafka.payment.PaymentConfirmation;
import com.yyessenali.ecommerce.model.Notification;
import com.yyessenali.ecommerce.model.NotificationType;
import com.yyessenali.ecommerce.repository.NotificationRepository;
import com.yyessenali.ecommerce.service.EmailService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
	private final NotificationRepository repository;
	private final EmailService emailService;
	
	@KafkaListener(topics = "payment-topic")
	public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) {
		log.info(String.format("Consuming the message from payment-topic Topic:: %s", paymentConfirmation));
		repository.save(
				Notification.builder()
					.type(NotificationType.PAYMENT_CONFIRMATION)
					.notificationDate(LocalDateTime.now())
					.paymentConfirmation(paymentConfirmation)
					.build()
		);
		
		// send email
		var customerName = paymentConfirmation.getCustomerFirstname() + " " + paymentConfirmation.getCustomerLastname();
		try {
			emailService.sendPaymentSuccessEmail(
					paymentConfirmation.getCustomerEmail(),
					customerName,
					paymentConfirmation.getAmount(),
					paymentConfirmation.getOrderReference());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@KafkaListener(topics = "order-topic")
	public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) {
		log.info(String.format("Consuming the message from order-topic Topic:: %s", orderConfirmation));
		repository.save(
				Notification.builder()
					.type(NotificationType.ORDER_CONFIRMATION)
					.notificationDate(LocalDateTime.now())
					.orderConfirmation(orderConfirmation)
					.build()
		);
		
		// send email
		var customerName = orderConfirmation.getCustomer().getFirstname() + " " + orderConfirmation.getCustomer().getLastname();
		try {
			emailService.sendOrderConfirmationEmail(
					orderConfirmation.getCustomer().getEmail(),
					customerName,
					orderConfirmation.getTotalAmount(),
					orderConfirmation.getOrderReference(),
					orderConfirmation.getProducts());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
