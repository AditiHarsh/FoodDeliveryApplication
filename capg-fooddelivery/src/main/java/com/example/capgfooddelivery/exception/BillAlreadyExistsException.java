package com.example.capgfooddelivery.exception;

public class BillAlreadyExistsException extends Exception{

	private String msg;
	
	public BillAlreadyExistsException() {
		super();
	}
	
	public BillAlreadyExistsException(String msg) {
		super();
		this.msg=msg;
	}
}
