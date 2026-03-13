package com.capg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.capg.model.Category;
import com.capg.model.FoodItem;

@Repository
public class FoodItemDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public FoodItem get(long itemId) {
		return em.find(FoodItem.class,itemId);
	}
	
	public void save(FoodItem foodItem,long categoryId) {
		
		Category category = em.find(Category.class,categoryId);
		
		category.getItems().add(foodItem);
		
		foodItem.setCategory(category);
		
		em.persist(foodItem);
		
		System.out.println("Food Item Added!");
	}

	public List<FoodItem> getItems(long categoryId) {
		
	     return em.createQuery(
	                "SELECT f FROM FoodItem f WHERE f.category.id = :cid",
	                FoodItem.class)
	                .setParameter("cid", categoryId)
	                .getResultList();
	}

	public void removeItem(long itemId) {
		FoodItem obj = get(itemId);
		em.remove(obj);
		System.out.println("Food Item Removed Successfully!");
	}
}
