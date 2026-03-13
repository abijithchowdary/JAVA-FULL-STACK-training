package com.capg.service;

import java.util.List;

import com.capg.model.Category;

public interface CategoryService {
	public void addCategory(String name,String description);
	public List<Category> getAllCategories();
}
