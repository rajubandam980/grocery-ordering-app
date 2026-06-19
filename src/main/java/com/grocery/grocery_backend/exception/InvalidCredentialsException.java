package com.grocery.grocery_backend.exception;

public class InvalidCredentialsException extends RuntimeException{
	
    public InvalidCredentialsException(String message) {
        super(message);
    }

}
