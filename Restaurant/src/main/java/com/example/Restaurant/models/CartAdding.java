package com.example.Restaurant.models;

import java.util.List;

import com.example.Restaurant.entities.Item;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CartAdding {
	
	int id;
	List<Item> list;

}
