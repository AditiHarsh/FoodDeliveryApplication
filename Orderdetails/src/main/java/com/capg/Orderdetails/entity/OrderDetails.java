package com.capg.Orderdetails.entity;


import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderDetails {
	@Id
	private int orderId;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime orderDate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartId")
	private FoodCart cart;
	private String orderStatus;
	private boolean isActive = true;

	public OrderDetails(int orderId, LocalDateTime orderDate, FoodCart cart, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.cart = cart;
		this.orderStatus = orderStatus;
	}

	public OrderDetails() {
		super();
	}

}