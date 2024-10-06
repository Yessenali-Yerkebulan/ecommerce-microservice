package com.yyessenali.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yyessenali.ecommerce.exception.ProductPurchaseException;
import com.yyessenali.ecommerce.model.Product;
import com.yyessenali.ecommerce.repository.ProductRepository;
import com.yyessenali.ecommerce.service.ProductService;
import com.yyessenali.ecommerce.web.mapper.ProductMapper;
import com.yyessenali.ecommerce.web.request.ProductPurchaseRequest;
import com.yyessenali.ecommerce.web.request.ProductRequest;
import com.yyessenali.ecommerce.web.response.ProductPurchaseResponse;
import com.yyessenali.ecommerce.web.response.ProductResponse;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService	{
	
	private final ProductRepository repository;
	private final ProductMapper mapper;
	
	@Override
	public Long createProduct(@Valid ProductRequest request) {
		Product product = mapper.toProduct(request);
		return repository.save(product).getId();
	}

	@Override
	public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
		var productIds = request
				.stream()
				.map(ProductPurchaseRequest::getProductId)
				.toList();
		
		var storedProducts = repository.findAllByIdInOrderById(productIds);
		
		if(productIds.size() != storedProducts.size()) {
			throw new ProductPurchaseException("One or more products does not exist");
		}
		
		var storedRequest = request.stream()
							.sorted(Comparator.comparing(ProductPurchaseRequest::getProductId))
							.toList();
		
		var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
		for(int i = 0; i < storedProducts.size(); i++) {
			var product = storedProducts.get(i);
			var productRequest = storedRequest.get(i);
			if(product.getAvailableQuantity() < productRequest.getQuantity()) {
				throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + productRequest.getProductId());
			}
			
			var newAvailableQuantity = product.getAvailableQuantity() - productRequest.getQuantity();
			product.setAvailableQuantity(newAvailableQuantity);
			repository.save(product);
			purchasedProducts.add(mapper.toProductPurchaseResponse(product, productRequest.getQuantity()));
		}
		
		return purchasedProducts;
							
	}

	@Override
	public ProductResponse findById(long productId) {
		return repository.findById(productId)
				.map(mapper::toProductResponse)
				.orElseThrow(() -> new EntityNotFoundException("Product not found with ID:: " + productId));
	}

	@Override
	public List<ProductResponse> findAll() {
		return repository.findAll()
				.stream()
				.map(mapper::toProductResponse)
				.collect(Collectors.toList());
	}

}
