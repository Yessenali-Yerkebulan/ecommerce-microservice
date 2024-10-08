package com.yyessenali.ecommerce.service;

import com.yyessenali.ecommerce.web.request.PaymentRequest;

import jakarta.validation.Valid;

public interface PaymentService {

	Long createPayment(@Valid PaymentRequest request);

}
