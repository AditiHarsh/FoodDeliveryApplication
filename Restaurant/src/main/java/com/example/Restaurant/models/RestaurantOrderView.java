package com.example.Restaurant.models;

import java.util.List;

import com.example.Restaurant.entities.OrderedItems;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RestaurantOrderView {
	
	int id;
	String rest_name;
	List<OrderedItems> orderedlist;
}
