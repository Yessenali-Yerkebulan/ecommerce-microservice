package com.yyessenali.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yyessenali.ecommerce.model.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long>{

}
