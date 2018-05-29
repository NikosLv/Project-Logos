package com.logos.service;

import java.util.List;

import com.logos.entity.Order;
import com.logos.entity.User;


public interface OrderService {
	
void saveOrder(Order order);
	
	Order findOrderById(int id);
	
	void deleteOrderById(int id);
	
	List<Order> findAllOrders();
	
	void updateOrder(Order order);
	
	List<Order> findOrderByUser(User user);

}
