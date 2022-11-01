package com.foodapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.entities.FoodCart;
import com.foodapp.entities.Item;
import com.foodapp.repo.IItemRepository;
import com.foodapp.service.ICartService;

@RestController
public class ICartController {
	@Autowired
	ICartService service;
	@Autowired
	IItemRepository repo;
	
	@PostMapping("/addItemToCart/{itemId}")
	public ResponseEntity<FoodCart> addItemToCart(@RequestBody FoodCart foodCart, @PathVariable String itemId)
	{
		Item item = repo.findById(itemId).get();
		FoodCart addToCart = service.addItemToCart(foodCart, item);
		if (addToCart == null) {

			return new ResponseEntity("Sorry ! item not added to cart", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FoodCart>(addToCart, HttpStatus.OK);
	}
	
	@PutMapping("/increaseQuantity/{itemId}/{quantity}")
	public ResponseEntity<FoodCart> increaseQuantity(@RequestBody FoodCart foodCart, @PathVariable String itemId,@PathVariable int quantity) 
	{
		Item item = repo.findById(itemId).get();
		FoodCart IncQnCart = service.increaseQuantity(foodCart, item, quantity);
		if (IncQnCart == null) {

			return new ResponseEntity("Sorry ! item not added to cart", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<FoodCart>(IncQnCart, HttpStatus.OK);
	}
	
	@PutMapping("/decreaseQuantity/{itemId}/{quantity}")
	public ResponseEntity<FoodCart> decreaseQuantity(@RequestBody FoodCart foodCart, @PathVariable String itemId, @PathVariable int quantity) 
		{
			Item item = repo.findById(itemId).get();
			FoodCart DecQnCart = service.decreaseQuantity(foodCart, item, quantity);

			return new ResponseEntity<FoodCart>(DecQnCart, HttpStatus.OK);
		}
	
	@DeleteMapping("/deleteItemFromCart/{itemId}")
	public ResponseEntity<FoodCart> deleteItem(@RequestBody FoodCart foodCart, @PathVariable String itemId)
	{
		Item item = repo.findById(itemId).get();
		FoodCart removeFromCart = service.deleteItem(foodCart, item);

		return new ResponseEntity<FoodCart>(removeFromCart, HttpStatus.OK);
	}
	
	@DeleteMapping("/clearcart")
	public ResponseEntity<FoodCart> clearCart(@RequestBody FoodCart foodCart)
	{
		FoodCart emptyCart = service.clearCart(foodCart);
		return new ResponseEntity<FoodCart>(emptyCart, HttpStatus.OK);
	}

}

