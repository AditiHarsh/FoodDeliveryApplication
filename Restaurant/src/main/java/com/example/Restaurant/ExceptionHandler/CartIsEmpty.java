package com.example.Restaurant.ExceptionHandler;

public class CartIsEmpty extends Exception {
	String message;

	public CartIsEmpty() {
		super();
		
	}

	public CartIsEmpty(String message) {
		super();
		this.message=message;
	}
	

}
