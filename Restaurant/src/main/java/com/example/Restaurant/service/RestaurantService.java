package com.example.Restaurant.service;

import java.util.List;

import com.example.Restaurant.ExceptionHandler.ItemCannotBeDeleted;
import com.example.Restaurant.ExceptionHandler.ItemNotPresentInRestaurant;
import com.example.Restaurant.ExceptionHandler.NoItemsInRestaurant;
import com.example.Restaurant.ExceptionHandler.NoRestaurantPresentInArea;
import com.example.Restaurant.ExceptionHandler.NoRestaurantPresentInCity;
import com.example.Restaurant.ExceptionHandler.NoSuchRestaurant;
import com.example.Restaurant.entities.Item;
import com.example.Restaurant.entities.Restaurant;
import com.example.Restaurant.models.RestaurantDetailsUpdate;
import com.example.Restaurant.models.RestaurantItemsUpdate;

public interface RestaurantService {
	Restaurant addRestaurant(Restaurant res);
	
	Restaurant removeRestaurant(int id) throws NoSuchRestaurant;
	
	List<Restaurant> getRestaurants();

	List<Item> getItemsOfARestaurnat(int res_id) throws  NoSuchRestaurant;

	List<Restaurant> getListOfRestaurantsByCity(String city) throws NoRestaurantPresentInCity;

	List<Restaurant> getListOfRestaurantsByArea(String area) throws NoRestaurantPresentInArea;

	Restaurant addItemsToRestaurant(RestaurantItemsUpdate update) throws NoSuchRestaurant;
	
	Restaurant removeItemsFromRestaurant(int id, String name) throws NoSuchRestaurant, ItemNotPresentInRestaurant, ItemCannotBeDeleted;

	Restaurant updateRestaurantDetails(RestaurantDetailsUpdate update) throws NoSuchRestaurant;

	Restaurant getRestaurant(int id) throws NoSuchRestaurant;
	
	
	
}
