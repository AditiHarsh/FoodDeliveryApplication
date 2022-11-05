package com.example.Restaurant.service;

import java.util.List;

import com.example.Restaurant.ExceptionHandler.CartIsEmpty;
import com.example.Restaurant.ExceptionHandler.CustomerAlreadyPresent;
import com.example.Restaurant.ExceptionHandler.CustomerNotPresent;
import com.example.Restaurant.ExceptionHandler.ItemNotPresent;
import com.example.Restaurant.ExceptionHandler.NoCustomerPresentInArea;
import com.example.Restaurant.ExceptionHandler.NoCustomerPresentInCity;
import com.example.Restaurant.ExceptionHandler.NoRestaurantPresentInCity;
import com.example.Restaurant.entities.Customer;
import com.example.Restaurant.entities.FoodCart;
import com.example.Restaurant.models.CartAdding;

public interface CustomerService {

	Customer addCustomer(Customer cust) throws CustomerAlreadyPresent;

	Customer updateCustomer(Customer cust) throws CustomerNotPresent;

	Customer deleteCustomer(int id) throws CustomerNotPresent;

	List<Customer> getAllCustomers();

	Customer getCustomerById(int id) throws CustomerNotPresent;

	Customer addItemToACart(CartAdding add) throws ItemNotPresent, CustomerNotPresent;

	FoodCart getCart(int id) throws CustomerNotPresent;

	Customer deleteItemFromCart(int cust, int item) throws ItemNotPresent,CustomerNotPresent, CartIsEmpty;

	List<Customer> getCustomerByCity(String city_name) throws NoCustomerPresentInCity;

	List<Customer> getCustomerByArea(String area_name) throws  NoCustomerPresentInArea;

}
