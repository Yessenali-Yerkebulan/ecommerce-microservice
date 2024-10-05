package com.yyessenali.ecommerce.web.mappers;

import org.springframework.stereotype.Component;

import com.yyessenali.ecommerce.documents.Customer;
import com.yyessenali.ecommerce.web.request.CustomerRequest;
import com.yyessenali.ecommerce.web.response.CustomerResponse;

@Component
public class CustomerMapper{
	public Customer toCustomer(CustomerRequest request) {
	    if (request == null) {
	      return null;
	    }
	    return Customer.builder()
	        .id(request.getId())
	        .firstname(request.getFirstname())
	        .lastname(request.getLastname())
	        .email(request.getEmail())
	        .address(request.getAddress())
	        .build();
	  }

	  public CustomerResponse fromCustomer(Customer customer) {
	    if (customer == null) {
	      return null;
	    }
	    return new CustomerResponse(
	        customer.getId(),
	        customer.getFirstname(),
	        customer.getLastname(),
	        customer.getEmail(),
	        customer.getAddress()
	    );
	  }
}
