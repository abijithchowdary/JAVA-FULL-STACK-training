package com.capg.Springboot.exception;

public class MyCustomException extends RuntimeException{

	public MyCustomException(String message) {
		super(message);
	}
}