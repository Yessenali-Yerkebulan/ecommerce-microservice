package com.yyessenali.ecommerce.web.request;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Validated
@Data
public class Customer {
	private String id;
	@NotNull(message = "Firstname is required")
	private String firstname;
	@NotNull(message = "Lastname is required")
	private String lastname;
	@NotNull(message = "Email is required")
	@Email(message = "Email is not valid")
	private String email;
}
