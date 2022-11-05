package com.example.Restaurant.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Restaurant.ExceptionHandler.CartIsEmpty;
import com.example.Restaurant.ExceptionHandler.CustomerNotPresent;
import com.example.Restaurant.ExceptionHandler.NoOrderPlacedByCustomer;
import com.example.Restaurant.ExceptionHandler.NoSuchOrder;
import com.example.Restaurant.ExceptionHandler.NotLoggedIn;
import com.example.Restaurant.entities.OrderDetail;
import com.example.Restaurant.models.AddingOrder;
import com.example.Restaurant.models.CustomerOrderView;
import com.example.Restaurant.models.RestaurantOrderView;
import com.example.Restaurant.service.LoginService;
import com.example.Restaurant.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/addOrder")
	public ResponseEntity<OrderDetail> addOrder(@RequestBody AddingOrder add, HttpServletRequest request) throws CustomerNotPresent, CartIsEmpty, NotLoggedIn{
		
		//checking login
		boolean validLogin = loginService.checkSession(request);
		if (!validLogin) {
			throw new NotLoggedIn("Not logged in");
		}
		
		OrderDetail order=service.addOrder(add.getCust_id());
		if(order==null) {
			return new ResponseEntity<OrderDetail>(order,HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		return new ResponseEntity<OrderDetail>(order, HttpStatus.OK);
	}
	
	@DeleteMapping("/cancelOrder/{id}")
	public ResponseEntity<String> cancelOrder(@PathVariable("id") int id, HttpServletRequest request) throws NoSuchOrder, NotLoggedIn{
		
		//checking login
		boolean validLogin = loginService.checkSession(request);
		if (!validLogin) {
			throw new NotLoggedIn("Not logged in");
		}
		
		int response= service.cancelOrder(id);
		if(response==0) {
			return new ResponseEntity<String>("Order Cancelled",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Order was not cancelled",HttpStatus.BAD_GATEWAY);
	}
	
	@GetMapping("/viewOrdersByCustomerId/{id}")
	public ResponseEntity<List<CustomerOrderView>> getOrdersByCustomerId(
		@PathVariable("id") int id, HttpServletRequest request	
		) throws NoOrderPlacedByCustomer, NotLoggedIn
	{
		
			//checking login
			boolean validLogin = loginService.checkSession(request);
			if (!validLogin) {
				throw new NotLoggedIn("Not logged in");
			}
		
		List<CustomerOrderView> list=service.getOrderByCustomerId(id);	
		if(list==null) {
			return new ResponseEntity<List<CustomerOrderView>>(new ArrayList<CustomerOrderView>(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<CustomerOrderView>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/viewOrdersByRestaurant/{rest_id}")
	public ResponseEntity<List<RestaurantOrderView>> getOrderOfARestaurant(@PathVariable("rest_id") int id, HttpServletRequest request) throws NoOrderPlacedByCustomer, NotLoggedIn{
		
		//checking login
		boolean validLogin = loginService.checkSession(request);
		if (!validLogin) {
			throw new NotLoggedIn("Not logged in");
		}
		
		List<RestaurantOrderView> view=service.getOrdersForARestaurant(id);
		return new ResponseEntity<List<RestaurantOrderView>>(view, HttpStatus.OK);
		
	}
	
}
