package com.example.capgfooddelivery.exception;

public class BillNotFoundException extends Exception{

	private String msg;
	
	public BillNotFoundException() {
		super();
	}
	
	public BillNotFoundException(String msg) {
		super();
		this.msg=msg;
	}
}
