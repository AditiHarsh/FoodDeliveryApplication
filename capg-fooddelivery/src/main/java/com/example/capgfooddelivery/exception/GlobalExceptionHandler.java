package com.example.capgfooddelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=BillNotFoundException.class)
	public ResponseEntity<String> BillNotFoundException(BillNotFoundException bnf){
		return new ResponseEntity<String>("Bill not found!",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=BillAlreadyExistsException.class)
	public ResponseEntity<String> BillAlreadyExistsException(BillAlreadyExistsException bae){
		return new ResponseEntity<String>("Bill already exists!",HttpStatus.CONFLICT);
	}
}
