package com.capg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.entity.Customer;
import com.capg.springboot.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	   @Autowired
	   private CustomerService service;
	   
	      
	   @PostMapping("/customer")
	   public int addCustomer(@RequestBody Customer customer) {
			
			return service.addCustomer(customer);
			
		}
	   
	   @GetMapping("/customer")
		public List<Customer> getAllCustomers() {
			
		  return service.getAllCustomers();
		}
		
	   
	   @GetMapping("/customer/{custId}")
		public Customer getCustomerById(@PathVariable int custId) {
			
			return service.getCustomerById(custId);
			
		}
	   
	   @PutMapping("/customer/{custId}")
		public int updateCustomer(@PathVariable int custId, @RequestBody Customer customer) {
			
			return service.updateCustomer(custId,customer);
			
		}
		
	   
	   @DeleteMapping("/customer")
		public int deleteCustomer(@RequestParam int custId) {
			
			return service.deleteCustomer(custId);
			
		}
}
