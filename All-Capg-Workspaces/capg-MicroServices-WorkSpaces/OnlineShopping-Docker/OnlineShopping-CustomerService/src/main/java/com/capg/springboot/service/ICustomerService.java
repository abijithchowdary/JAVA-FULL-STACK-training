package com.capg.springboot.service;

import java.util.List;

import com.capg.springboot.dto.CustomerRequest;
import com.capg.springboot.entity.Customer;

public interface ICustomerService {
	
	// Register — takes CustomerRequest (has email+password+role+profile)
	Customer addCustomer(CustomerRequest request);
	
	// Update customer profile — name, mobile, city, pincode
	Customer updateCustomer(Customer customer);

    // Delete customer by customerId
    Customer removeCustomer(Long customerId);

    // Get customer by customerId
    Customer viewCustomer(Long customerId);

    // Get all customers — Admin only
    List<Customer> viewAllCustomers();

    // Filter by city — Admin use case
    List<Customer> viewCustomersByCity(String city);
}
