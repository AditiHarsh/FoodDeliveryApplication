package com.example.capgfooddelivery.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capgfooddelivery.entity.OrderDetails;
import com.example.capgfooddelivery.repo.OrderDetailsRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	OrderDetailsRepository orderRepo;

	@Override
	public OrderDetails addOrder(OrderDetails order) {
		return orderRepo.save(order);
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		OrderDetails orderUpdate = null;
			orderUpdate = orderRepo.save(order);
		return orderUpdate;
	}

	@Override
	public OrderDetails removeOrder(OrderDetails order) {
		OrderDetails orderUpdate = order;
		
			orderRepo.save(order);
			return orderUpdate;
	}

	@Override
	public OrderDetails viewOrder(OrderDetails order) {
		OrderDetails showOrder = orderRepo.findById(order.getOrderId()).get();
		
			return showOrder;
	
	}

//	@Override
//	public List<OrderDetails> viewAllOrders(Restaurant res) {
//		List<OrderDetails> list = orderRepo.viewAllOrders(res.getRestaurantId(), res.getRestaurantName());
//		List<OrderDetails> newList = new ArrayList<>();
//		for (OrderDetails o : list) {
//			if (o.isActive())
//				newList.add(o);
//
//		}
//		return newList;
//	}
//
//	@Override
//	public List<OrderDetails> viewAllOrders(Customer customer) {
//		List<OrderDetails> list = orderRepo.viewAllOrders(customer.getCustomerId());
//		List<OrderDetails> newList = new ArrayList<>();
//		for (OrderDetails o : list) {
//			if (o.isActive())
//				newList.add(o);
//
//		}
//		return newList;
//	}

}
