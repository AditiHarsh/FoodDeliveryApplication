package com.capg.Orderdetails.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.Orderdetails.entity.Customer;
import com.capg.Orderdetails.entity.OrderDetails;
import com.capg.Orderdetails.exception.OrderNotExists;
import com.capg.Orderdetails.repo.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository orderRepo;

	@Override
	public OrderDetails addOrder(OrderDetails order) throws Exception {
		if(orderRepo.existsById(order.getOrderId()))
			throw new OrderNotExists("Order Id already present");
		return orderRepo.save(order);
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		OrderDetails orderUpdate = null;
		if (orderRepo.existsById(order.getOrderId()) && orderRepo.findById(order.getOrderId()).get().isActive())
			orderUpdate = orderRepo.save(order);
		return orderUpdate;
	}

	@Override
	public OrderDetails removeOrder(OrderDetails order) throws Exception {
		if(!orderRepo.existsById(order.getOrderId()))
			throw new OrderNotExists("Order Id not present");
		OrderDetails orderUpdate = order;
		if (orderRepo.existsById(order.getOrderId())) {
			order.setActive(false);
			orderRepo.save(order);
			orderRepo.deleteById(order.getOrderId());
			return orderUpdate;
		}
		return null;
	}

	@Override
	public OrderDetails viewOrder(OrderDetails order) throws Exception {
		if(!orderRepo.existsById(order.getOrderId()))
			throw new OrderNotExists("Order Id not present");
		OrderDetails showOrder = orderRepo.findById(order.getOrderId()).get();
		if (showOrder.isActive())
			return showOrder;
		return null;
	}

	
//	@Override
//	public List<OrderDetails> viewAllOrders(Restaurant res) {
//		List<OrderDetails> list = orderRepo.viewAllOrdersRes(res.getRestaurantId());
//		List<OrderDetails> newList = new ArrayList<>();
//		for (OrderDetails o : list) {
//			if (o.isActive())
//				newList.add(o);
//
//		}
//		return newList;
//	}

	@Override
	public List<OrderDetails> viewAllOrders(Customer customer) throws Exception {
//		if(!orderRepo.existsById(customer.getCustomerId()))
//			throw new OrderNotExists("Customer not present");
//		Customer cust;
//		
//		if(customer.getCustomerId().get)
//			return null;
		List<OrderDetails> list = orderRepo.viewAllOrders(customer.getCustomerId());
		List<OrderDetails> newList = new ArrayList<>();
		for (OrderDetails o : list) {
			if (o.isActive())
				newList.add(o);

		}
		if(newList.isEmpty())
			return null;
		else
			return newList;
	}

}