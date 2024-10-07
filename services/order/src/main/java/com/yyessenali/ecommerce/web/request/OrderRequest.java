package com.yyessenali.ecommerce.web.request;

import java.math.BigDecimal;
import java.util.List;

import com.yyessenali.ecommerce.model.PaymentMethod;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderRequest {
	private long id;
	private String reference;
	@Positive(message = "Order amount should be positive")
	private BigDecimal amount;
	@NotNull(message = "Payment method should be precised")
	private PaymentMethod paymentMethod;
	@NotNull(message = "Customer should be present")
	@NotEmpty(message = "Customer should be present")
	@NotBlank(message = "Customer should be present")
	private String customerId;
	@NotEmpty(message = "You should at least purchase one product")
	private List<PurchaseRequest> products;
}
