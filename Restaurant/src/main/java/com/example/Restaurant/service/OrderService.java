package com.example.Restaurant.service;

import java.util.List;

import com.example.Restaurant.ExceptionHandler.CartIsEmpty;
import com.example.Restaurant.ExceptionHandler.CustomerNotPresent;
import com.example.Restaurant.ExceptionHandler.NoOrderPlacedByCustomer;
import com.example.Restaurant.ExceptionHandler.NoSuchOrder;
import com.example.Restaurant.entities.OrderDetail;
import com.example.Restaurant.models.CustomerOrderView;
import com.example.Restaurant.models.RestaurantOrderView;

public interface OrderService {

	OrderDetail addOrder(int cust_id) throws CustomerNotPresent,CartIsEmpty;

	int cancelOrder(int id) throws NoSuchOrder;

	List<CustomerOrderView> getOrderByCustomerId(int id) throws NoOrderPlacedByCustomer;
	
	List<RestaurantOrderView> getOrdersForARestaurant(int id) throws NoOrderPlacedByCustomer;
}
