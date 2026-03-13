package com.capg.customer.service;

import java.util.List;

import com.capg.customer.entity.Customer;
import com.capg.customer.entity.CustomerProfile;

public interface CustomerService {
	
	public Customer createCustomer(Customer customer);
	
	public Customer getCustomerById(int customerId);
	
	public List<Customer> getAllCustomers();
	
	public void deleteCustomer(int customerId);
	
	public CustomerProfile getCutomerProfile(int customerId);
}
