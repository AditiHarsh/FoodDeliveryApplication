package com.capg.Orderdetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=OrderNotExists.class)
	public ResponseEntity<String> OrderNotExists(OrderNotExists cna){
		return new ResponseEntity<String>(cna.msg, HttpStatus.CONFLICT);
	}

}
