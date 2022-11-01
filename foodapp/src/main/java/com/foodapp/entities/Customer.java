package com.foodapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	String firstName;
	String lastName;
	@Id
	String customerId;
	int age;
	String gender;
	int mobileNo;
	String email;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer() {
		super();
		
	}
	public Customer(String firstName, String lastName, String customerId, int age, String gender, int mobileNo,
			String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerId = customerId;
		this.age = age;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.email = email;
	}
	
}
