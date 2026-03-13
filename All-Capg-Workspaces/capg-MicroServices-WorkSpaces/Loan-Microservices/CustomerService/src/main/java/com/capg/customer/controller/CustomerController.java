package com.capg.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.customer.entity.Customer;
import com.capg.customer.entity.CustomerProfile;
import com.capg.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return service.createCustomer(customer);
	}
	
	@GetMapping("/getCustomer/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return service.getCustomerById(id);
	}
	
	@GetMapping("/getallcustomers")
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable int id) {
		service.deleteCustomer(id);
		return "Customer deleted successfully";
	}
	
	@GetMapping("/profile/{id}")
	public CustomerProfile getCustomerProfile(@PathVariable int id) {
		return service.getCutomerProfile(id);
	}
}
