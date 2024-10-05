package com.yyessenali.ecommerce.service;

import java.util.List;

import com.yyessenali.ecommerce.web.request.CustomerRequest;
import com.yyessenali.ecommerce.web.response.CustomerResponse;

public interface CustomerService {
	String createCustomer(CustomerRequest customerDto);
	
	void updateCustomer(CustomerRequest customerDto);

	List<CustomerResponse> findAllCustomers();

	Boolean existsById(String customerId);

	CustomerResponse findById(String customerId);

	void deleteCustomer(String customerId);
}
