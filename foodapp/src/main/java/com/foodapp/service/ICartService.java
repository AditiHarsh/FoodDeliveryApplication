package com.foodapp.service;

import com.foodapp.entities.FoodCart;
import com.foodapp.entities.Item;

public interface ICartService {
	public FoodCart addItemToCart(FoodCart Cart,Item item);
	public FoodCart increaseQuantity(FoodCart Cart,Item item,int qnt);
	public FoodCart decreaseQuantity(FoodCart Cart,Item item,int qnt);
	public FoodCart deleteItem(FoodCart Cart,Item item);
	public FoodCart clearCart(FoodCart Cart);
}
