package com.yyessenali.ecommerce.web.mapper;

import org.springframework.stereotype.Component;

import com.yyessenali.ecommerce.model.Category;
import com.yyessenali.ecommerce.model.Product;
import com.yyessenali.ecommerce.web.request.ProductRequest;
import com.yyessenali.ecommerce.web.response.ProductPurchaseResponse;
import com.yyessenali.ecommerce.web.response.ProductResponse;

@Component
public class ProductMapper {
	public Product toProduct(ProductRequest request) {
		return Product.builder()
				.id(request.getId())
				.name(request.getName())
				.description(request.getDescription())
				.price(request.getPrice())
				.availableQuantity(request.getAvailableQuantity())
				.category(Category.builder().id(request.getCategoryId()).build())
				.build();
	}
	
	public ProductResponse toProductResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.availableQuantity(product.getAvailableQuantity())
				.price(product.getPrice())
				.categoryId(product.getCategory().getId())
				.categoryName(product.getCategory().getName())
				.categoryDescription(product.getCategory().getDescription())
				.build();
	}

	public ProductPurchaseResponse toProductPurchaseResponse(Product product, double quantity) {
		return ProductPurchaseResponse.builder()
				.productId(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.quantity(quantity)
				.build();
	}
}
