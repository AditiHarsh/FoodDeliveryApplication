package com.capg.Orderdetails.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FoodCart {
	@Id
	@Column(name = "cartId")
	private int cartId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;

	
	@ManyToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
	private List<Item> itemList;
}
