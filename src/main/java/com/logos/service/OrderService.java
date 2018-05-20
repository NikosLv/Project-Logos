package com.logos.service;

import java.util.List;

import com.logos.entity.Order;


public interface OrderService {
	
void saveOrder(Order order);
	
	Order findOrderById(int id);
	
	void deleteOrderById(int id);
	
	List<Order> findAllOrders();
	
	void updateOrder(Order order);

}
