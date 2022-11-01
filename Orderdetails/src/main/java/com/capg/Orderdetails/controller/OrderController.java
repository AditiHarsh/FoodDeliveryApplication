package com.capg.Orderdetails.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.Orderdetails.entity.Customer;
import com.capg.Orderdetails.entity.OrderDetails;
import com.capg.Orderdetails.entity.Restaurant;
import com.capg.Orderdetails.service.IOrderService;

@RestController
public class OrderController {

	@Autowired
	IOrderService service;
	

	@PostMapping("/addOrder")
	public ResponseEntity<OrderDetails> addOrder(@RequestBody OrderDetails order, HttpServletRequest request) throws Exception {
	
		 OrderDetails saved = service.addOrder(order);
		return new ResponseEntity<OrderDetails>(saved, HttpStatus.OK);
	}

	@PutMapping("/updateOrder")
	public ResponseEntity<OrderDetails> updateOrder(@RequestBody OrderDetails order, HttpServletRequest request) {
		
		// todo owner check
		OrderDetails newOrder = service.updateOrder(order);
		if (newOrder == null) {
			return new ResponseEntity("Sorry! OrderDetails not available to Update!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<OrderDetails>(newOrder, HttpStatus.OK);
	}

	@DeleteMapping("/removeOrder")
	public String  removeOrder(@RequestBody OrderDetails order) throws Exception {

		// todo owner check
		OrderDetails delOrder = service.removeOrder(order);
		if (delOrder == null) {
			return "Sorry! OrderDetails not available!";
		}
		return "Deleted Sucessfully";
	}

	@GetMapping("/viewOrder")
	public ResponseEntity<OrderDetails> viewOrder(@RequestBody OrderDetails order, HttpServletRequest request) throws Exception {
		
		OrderDetails showOrder = service.viewOrder(order);
		if (showOrder == null) {
			return new ResponseEntity("Sorry! OrderDetails not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<OrderDetails>(showOrder, HttpStatus.OK);
	}
//	@GetMapping("/viewAllOrders/restaurant")
//	public ResponseEntity<List<OrderDetails>> viewAllOrders(@RequestBody Restaurant res, HttpServletRequest request) {
//		
//
//		List<OrderDetails> resultSet = service.viewAllOrders(res);
//		if (resultSet == null) {
//			return new ResponseEntity("Sorry! OrderDetails not available!", HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<List<OrderDetails>>(resultSet, HttpStatus.OK);
//	}

	@GetMapping("/viewAllOrders/customer")
	public ResponseEntity<List<OrderDetails>> viewAllOrders(@RequestBody Customer customer,
			HttpServletRequest request) throws Exception {
		
		// todo owner check

		List<OrderDetails> resultSet = service.viewAllOrders(customer);
		if (resultSet == null) {
			return new ResponseEntity("Sorry! OrderDetails not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<OrderDetails>>(resultSet, HttpStatus.OK);
	}
}