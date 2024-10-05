package com.yyessenali.ecommerce.exception;

import java.util.Map;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse {
	Map<String, String> errors;
}
