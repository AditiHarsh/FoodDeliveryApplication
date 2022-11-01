package com.foodapp.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.foodapp.entities.Customer;
import com.foodapp.entities.Item;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class FoodCart {
	
	@Id
	@Column(name="CartId")
	private String CartId;

	@OneToOne
	private Customer customer;
	@ManyToMany
	private List<Item> ItemList;
	public String getCartId() {
		return CartId;
	}
	public void setCartId(String cartId) {
		CartId = cartId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Item> getItemList() {
		return ItemList;
	}
	public void setItemList(List<Item> itemList) {
		ItemList = itemList;
	}
	
}
