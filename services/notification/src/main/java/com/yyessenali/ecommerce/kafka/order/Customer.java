package com.yyessenali.ecommerce.kafka.order;

import lombok.Data;

@Data
public class Customer {
	private String id;
	private String firstname;
	private String lastname;
	private String email;
}
