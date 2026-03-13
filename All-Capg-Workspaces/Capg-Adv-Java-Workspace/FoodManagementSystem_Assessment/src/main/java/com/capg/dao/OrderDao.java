package com.capg.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.capg.model.FoodItem;
import com.capg.model.Order;

@Repository
public class OrderDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void saveOrder(List<Long> fooditemIds,String name) {
		
		Order order = new Order();
		
		double price = 0;
		
		order.setCustomerName(name);
		
		List<FoodItem> lists = new ArrayList<>();
		
		for(long id : fooditemIds) {
			
			FoodItem item = em.find(FoodItem.class,id);
			
			if(item == null) {
				System.out.println("One of the Item doesn't exist!");
				System.out.println("Please check the list of items and order again!");
				return;
			}
			else {
				lists.add(item);
				price += item.getPrice();
			}
		}
		
		order.setTotalAmount(price);
		order.setOrderDate(Date.valueOf(LocalDate.now()));
		
		for(FoodItem item : lists) {
			order.getFoodItems().add(item);
			item.getOrders().add(order);
		}
		
		em.persist(order);
		
		System.out.println("Order Saved Succesfully");
	}

	public double getTotal(long orderId) {
		Order order = em.find(Order.class,orderId);
		
		return order.getTotalAmount();
	}
	
}
