package com.design.command;

import java.util.List;
import java.util.ArrayList;

public class Broker {
	private List<Order> orderList = new ArrayList<Order>();
	
	public void takeOrder(Order order) {
		orderList.add(order);
	}
	
	public void placeOrder() {
		for(Order o : orderList) {
			o.execute();
		}
	}
}
