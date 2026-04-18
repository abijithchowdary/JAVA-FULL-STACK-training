package com.capg.springboot.exceptions;

public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(String message) {
        super(message);
    }
}
