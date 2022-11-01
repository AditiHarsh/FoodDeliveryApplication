package com.example.capgfooddelivery.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class OrderDetails {

	@Id
	private int orderId;
	
	private LocalDateTime orderTime;
	private String orderStatus;
	
	public OrderDetails() {
		this.orderTime=orderTime.now();
	}
	
	public OrderDetails(int orderId,String orderStatus) {
		this.orderId=orderId;
		this.orderStatus=orderStatus;
		this.orderTime=orderTime.now();
	}
}
