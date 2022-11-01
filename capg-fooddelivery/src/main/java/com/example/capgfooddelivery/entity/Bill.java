package com.example.capgfooddelivery.entity;


import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity


public class Bill {

	@Id
	private int billId;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime billDate;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="orderId")
	private OrderDetails orderdetail;
	
	private int totalItems;
	private double totalCost;
	
	public Bill() {
		this.billDate=billDate.now();
	}
	
	public Bill(int billId,int totalItems,double totalCost) {
		this.billId=billId;
		this.totalItems=totalItems;
		this.totalCost=totalCost;
		this.billDate=billDate.now();
	}
}
