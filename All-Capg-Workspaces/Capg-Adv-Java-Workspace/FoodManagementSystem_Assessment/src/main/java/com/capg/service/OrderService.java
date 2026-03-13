package com.capg.service;

import java.util.List;

public interface OrderService {
	
	public void placeOrder(List<Long> foodItemsIds,String customerName);
	
	public double calculateTotal(long orderId);
}
