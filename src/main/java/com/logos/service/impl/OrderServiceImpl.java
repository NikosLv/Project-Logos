package com.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logos.entity.Order;
import com.logos.repository.OrderRepository;
import com.logos.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired OrderRepository orderRepository;
	
	@Override
	public void saveOrder(Order order) {
		orderRepository.save(order);
		
	}

	@Override
	public Order findOrderById(int id) {
		return orderRepository.getOne(id);
	}

	@Override
	public void deleteOrderById(int id) {
		orderRepository.deleteById(id);
		
	}

	@Override
	public List<Order> findAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public void updateOrder(Order order) {
		orderRepository.save(order);
		
	}

}
