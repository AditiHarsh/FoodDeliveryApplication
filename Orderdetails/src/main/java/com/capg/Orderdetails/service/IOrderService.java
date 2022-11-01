package com.capg.Orderdetails.service;

import java.util.List;

import com.capg.Orderdetails.entity.Customer;
import com.capg.Orderdetails.entity.OrderDetails;
import com.capg.Orderdetails.entity.Restaurant;

public interface IOrderService {
	public OrderDetails addOrder(OrderDetails order) throws Exception;

	public OrderDetails updateOrder(OrderDetails order);

	public OrderDetails removeOrder(OrderDetails order) throws Exception;

	public OrderDetails viewOrder(OrderDetails order) throws Exception;

	//public List<OrderDetails> viewAllOrders(Restaurant res);

	public List<OrderDetails> viewAllOrders(Customer customer) throws Exception;
}