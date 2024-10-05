package com.yyessenali.ecommerce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yyessenali.ecommerce.documents.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

}
