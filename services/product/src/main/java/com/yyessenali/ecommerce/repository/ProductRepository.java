package com.yyessenali.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yyessenali.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findAllByIdInOrderById(List<Long> productIds);
}
