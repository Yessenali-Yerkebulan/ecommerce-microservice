package com.yyessenali.ecommerce.web.response;

import com.yyessenali.ecommerce.documents.Address;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerResponse {
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private Address address;
}
