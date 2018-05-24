package com.logos.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.logos.entity.Order;

public class OrderFormatter implements Formatter<Order> {

	@Override
	public String print(Order order, Locale locale) {
		System.out.println("Print: " + order.getId());
		return String.valueOf(order.getId());
	}

	@Override
	public Order parse(String objId, Locale arg1) throws ParseException {
		System.out.println("Parse: " + objId);
		objId.split(", ");
		int orderId= Integer.valueOf(objId.split(", ")[0]);
		
		Order order = new Order();
		order.setId(orderId);
		return order;
	}

}
