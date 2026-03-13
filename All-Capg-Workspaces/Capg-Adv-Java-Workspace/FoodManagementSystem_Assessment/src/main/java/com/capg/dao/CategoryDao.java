package com.capg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.capg.model.Category;

@Repository
public class CategoryDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void addCategory(Category obj) {
		em.persist(obj);
	}
	
	public List<Category> getAllCategories() {

        String jpql = "SELECT c FROM Category c";

        return em.createQuery(jpql, Category.class)
                 .getResultList();
    }
}
