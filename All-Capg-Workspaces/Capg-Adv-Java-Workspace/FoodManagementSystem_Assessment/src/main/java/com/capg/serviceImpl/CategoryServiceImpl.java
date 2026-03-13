package com.capg.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.CategoryDao;
import com.capg.model.Category;
import com.capg.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categorydao;
	
	public void addCategory(String name,String description) {
		
		Category obj = new Category();
	    
	    obj.setCategoryName(name);
	    obj.setDescription(description);
	    
		categorydao.addCategory(obj);
		
		System.out.println("Category Added!");
	}
	
	public List<Category> getAllCategories(){
		return categorydao.getAllCategories();
	}
}
