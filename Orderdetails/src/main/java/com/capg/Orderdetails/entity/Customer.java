package com.capg.Orderdetails.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
	@Id
	private int customerId;
	private String firstName;
	private boolean isActive=true;
}
