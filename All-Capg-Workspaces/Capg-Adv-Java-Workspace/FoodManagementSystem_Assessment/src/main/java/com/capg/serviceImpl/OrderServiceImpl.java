package com.capg.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.OrderDao;
import com.capg.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderdao;

	@Override
	public void placeOrder(List<Long> foodItemsIds, String customerName) {
		orderdao.saveOrder(foodItemsIds, customerName);
	}

	@Override
	public double calculateTotal(long orderId) {
		return orderdao.getTotal(orderId);
	}

}
