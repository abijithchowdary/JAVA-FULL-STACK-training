package com.capg.springboot.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.capg.springboot.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public int addCustomer(Customer customer) {
		
	     em.persist(customer);
	     return customer.getCustId();
		
	}
	public List<Customer> getAllCustomers() {
		
	   Query query=(Query) em.createQuery("select c from Customer c",Customer.class);
	     List<Customer> list=  query.getResultList();
	     return list;	
	}
	
	public Customer getCustomerById(int id) {
		
		return em.find(Customer.class,id);
		
	}
	public int updateCustomer(int id, Customer customer) {
		
		Customer cust=em.find(Customer.class,id);
          cust.setCname(customer.getCname());
          cust.setAddress(customer.getAddress());
		
	     em.merge(cust);
	     return customer.getCustId();
		
	}
	
	public int deleteCustomer(int id) {
		
		Customer cust=em.find(Customer.class,id);
		
	     em.remove(cust);
	     return cust.getCustId();
		
	}
	
}
