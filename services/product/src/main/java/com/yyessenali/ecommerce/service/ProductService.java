package com.yyessenali.ecommerce.service;

import java.util.List;

import com.yyessenali.ecommerce.web.request.ProductPurchaseRequest;
import com.yyessenali.ecommerce.web.request.ProductRequest;
import com.yyessenali.ecommerce.web.response.ProductPurchaseResponse;
import com.yyessenali.ecommerce.web.response.ProductResponse;

import jakarta.validation.Valid;

public interface ProductService {

	Long createProduct(@Valid ProductRequest request);

	List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request);

	ProductResponse findById(long productId);

	List<ProductResponse> findAll();

}
