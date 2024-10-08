package com.yyessenali.ecommerce.client.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
	private String id;
	private String firstname;
	private String lastname;
	private String email;
}
