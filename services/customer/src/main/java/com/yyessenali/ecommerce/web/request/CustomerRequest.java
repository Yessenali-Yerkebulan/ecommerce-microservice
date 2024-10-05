package com.yyessenali.ecommerce.web.request;

import com.yyessenali.ecommerce.domain.Address;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequest {
	private String id;
	
	@NotNull(message = "Customer firstname is required")
	private String firstname;
	
	@NotNull(message = "Customer lastname is required")
	private String lastname;
	
	@NotNull(message = "Customer email is required")
	@Email(message = "Customer email is not a valid email address")
	private String email;
	
	private Address address;
}
