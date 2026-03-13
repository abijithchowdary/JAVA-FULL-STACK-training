package com.capg.service;

import java.util.List;

import com.capg.model.FoodItem;

public interface FoodService {
	
	public void addFoodItem(long categoryId,String name,double price);
	
	public List<FoodItem> getItemsByCategory(long categoryId);
	
	public void removeFoodItem(long itemId);
}
