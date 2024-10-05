package com.yyessenali.ecommerce.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yyessenali.ecommerce.domain.Customer;
import com.yyessenali.ecommerce.exception.CustomerNotFoundException;
import com.yyessenali.ecommerce.repository.CustomerRepository;
import com.yyessenali.ecommerce.service.CustomerService;
import com.yyessenali.ecommerce.web.mappers.CustomerMapper;
import com.yyessenali.ecommerce.web.request.CustomerRequest;
import com.yyessenali.ecommerce.web.response.CustomerResponse;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
	
	private final CustomerRepository repository;
	private final CustomerMapper customerMapper;
	
	@Override
	public Boolean existsById(String customerId) {
		return repository.findById(customerId).isPresent();
	}
	
	@Override
	public String createCustomer(CustomerRequest customerDto) {
	    Customer customer = repository.save(customerMapper.toCustomer(customerDto));
		return customer.getId();
	}

	@Override
	public void updateCustomer(CustomerRequest customerDto) {
		Customer customer = repository.findById(customerDto.getId())
							.orElseThrow(() -> new CustomerNotFoundException(
								String.format("Cannot update customer :: No customer found with provided ID:: %s",
								customerDto.getId()
								)
							));
		mergerCustomer(customer, customerDto);
		repository.save(customer);
	}
	
	private void mergerCustomer(Customer customer, CustomerRequest customerDto) {
		if(StringUtils.isNotBlank(customerDto.getFirstname())) {
			customer.setFirstname(customerDto.getFirstname());
		}
		if(StringUtils.isNotBlank(customerDto.getLastname())) {
			customer.setLastname(customerDto.getLastname());
		}
		if(StringUtils.isNotBlank(customerDto.getEmail())) {
			customer.setEmail(customerDto.getEmail());
		}
		if(customerDto.getAddress() != null) {
			customer.setAddress(customerDto.getAddress());
		}
	}

	@Override
	public List<CustomerResponse> findAllCustomers() {
		return repository.findAll()
			.stream()
			.map(customerMapper::fromCustomer)
			.collect(Collectors.toList());
	}

	@Override
	public CustomerResponse findById(String customerId) {
		return repository.findById(customerId)
		       .map(customerMapper::fromCustomer)
		       .orElseThrow(() -> new CustomerNotFoundException(
		       	  String.format("No customer found with the ID :: %s", customerId)
		       ));
	}

	@Override
	public void deleteCustomer(String customerId) {
		repository.deleteById(customerId);
	}
}
