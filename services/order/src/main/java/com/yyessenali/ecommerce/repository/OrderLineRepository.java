package com.yyessenali.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yyessenali.ecommerce.model.OrderLine;
import com.yyessenali.ecommerce.web.response.OrderLineResponse;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long>{

	List<OrderLine> findAllByOrderId(long orderId);

}
