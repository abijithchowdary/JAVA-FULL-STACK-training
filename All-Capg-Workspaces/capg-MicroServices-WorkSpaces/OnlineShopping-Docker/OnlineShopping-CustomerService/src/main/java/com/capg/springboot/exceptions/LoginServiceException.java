package com.capg.springboot.exceptions;

public class LoginServiceException extends RuntimeException {
	public LoginServiceException(String message) {
        super(message);
    }
}
