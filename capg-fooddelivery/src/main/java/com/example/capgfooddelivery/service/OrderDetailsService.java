package com.example.capgfooddelivery.service;

import java.util.List;

import com.example.capgfooddelivery.entity.OrderDetails;

public interface OrderDetailsService {

	public OrderDetails addOrder(OrderDetails order);

	public OrderDetails updateOrder(OrderDetails order);

	public OrderDetails removeOrder(OrderDetails order);

	public OrderDetails viewOrder(OrderDetails order);

	//public List<OrderDetails> viewAllOrders(Restaurant res);

	//public List<OrderDetails> viewAllOrders(Customer customer);
}
