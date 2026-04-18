package com.capg.springboot.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException {
	public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
