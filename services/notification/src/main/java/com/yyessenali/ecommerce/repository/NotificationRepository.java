package com.yyessenali.ecommerce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yyessenali.ecommerce.model.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String>{

}
