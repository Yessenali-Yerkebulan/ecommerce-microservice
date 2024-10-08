package com.yyessenali.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yyessenali.ecommerce.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
