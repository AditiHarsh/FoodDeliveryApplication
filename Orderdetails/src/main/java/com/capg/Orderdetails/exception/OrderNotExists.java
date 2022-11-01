package com.capg.Orderdetails.exception;

public class OrderNotExists extends Exception{
	String msg;

	public OrderNotExists(String msg) {
		super();
		this.msg = msg;
	}

	public OrderNotExists() {
		super();
	}

}
