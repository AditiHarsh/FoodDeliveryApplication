package com.capg.Orderdetails.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	@Id
	@Column(name="itemId")
	private int itemId;
	private String itemName;
	//ManyToOne
//	@ManyToOne()
//	private List<Restaurant> restaurants;
	
	
//	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "itemList")
//	private List<Restaurant> restaurants;
}
