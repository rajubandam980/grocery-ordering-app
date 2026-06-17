package com.grocery.grocery_backend.exception;

public class ProductNotFoundException extends RuntimeException{
	
	public ProductNotFoundException(String message) {
		super(message);
		
	}

}
