package com.capg.Springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<String> handleCustomException(MyCustomException ex){
		return new ResponseEntity<>("Custom Exception : "+ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleGenericException(Exception ex){
		return new ResponseEntity<>("an error occered : "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
