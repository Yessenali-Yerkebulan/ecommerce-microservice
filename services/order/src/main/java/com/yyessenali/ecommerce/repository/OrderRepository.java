package com.yyessenali.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yyessenali.ecommerce.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
