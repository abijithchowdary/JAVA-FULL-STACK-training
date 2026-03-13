package com.capg.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.FoodItemDao;
import com.capg.model.FoodItem;
import com.capg.service.FoodService;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	private FoodItemDao foodItemDao;

	@Override
	public void addFoodItem(long categoryId, String name, double price) {
		
		FoodItem foodItem = new FoodItem();
		
		foodItem.setItemName(name);
		
		foodItem.setPrice(price);
		
		foodItemDao.save(foodItem,categoryId);
	}

	@Override
	public List<FoodItem> getItemsByCategory(long categoryId) {
		return foodItemDao.getItems(categoryId);
	}
	@Override
	public void removeFoodItem(long itemId) {
		
		FoodItem obj = foodItemDao.get(itemId);
		
		if(obj == null) {
			System.out.println("No FoodItem Found!");
		}
		else {
			foodItemDao.removeItem(itemId);
		}
	}

}
