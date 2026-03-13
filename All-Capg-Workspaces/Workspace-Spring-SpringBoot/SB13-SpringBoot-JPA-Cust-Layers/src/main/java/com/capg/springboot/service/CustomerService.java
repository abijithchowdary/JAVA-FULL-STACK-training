package com.capg.springboot.service;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.springboot.entity.Customer;
import com.capg.springboot.repository.CustomerRepository;

@Service
public class CustomerService {
	
	
	@Autowired
	private CustomerRepository repo;
	
	public int addCustomer(Customer customer) {
		
		return repo.addCustomer(customer);
		
	}
	public List<Customer> getAllCustomers() {
		
	  return repo.getAllCustomers();
	}
	
	public Customer getCustomerById(int id) {
		
		return repo.getCustomerById(id);
		
	}
	public int updateCustomer(int id, Customer customer) {
		
		return repo.updateCustomer(id,customer);
		
	}
	
	public int deleteCustomer(int id) {
		
		return repo.deleteCustomer(id);
		
	}

}
