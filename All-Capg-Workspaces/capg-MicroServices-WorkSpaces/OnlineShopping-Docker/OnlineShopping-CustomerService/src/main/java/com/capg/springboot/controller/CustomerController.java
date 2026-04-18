package com.capg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.dto.CustomerRequest;
import com.capg.springboot.entity.Customer;
import com.capg.springboot.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;
	
	
	@PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(
            @RequestBody CustomerRequest request) {
        Customer saved = customerService.addCustomer(request);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

   
    @PutMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(
            @RequestBody Customer customer) {
        Customer updated = customerService.updateCustomer(customer);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }


    @DeleteMapping("/removeCustomer/{customerId}")
    public ResponseEntity<Customer> removeCustomer(
            @PathVariable Long customerId) {
        Customer removed = customerService.removeCustomer(customerId);
        return new ResponseEntity<>(removed, HttpStatus.OK);
    }


    @GetMapping("/getCustomer/{customerId}")
    public ResponseEntity<Customer> getCustomer(
            @PathVariable Long customerId) {
        Customer customer = customerService.viewCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    
    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.viewAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

  
    @GetMapping("/getByCity/{city}")
    public ResponseEntity<List<Customer>> getByCity(
            @PathVariable String city) {
        List<Customer> customers = customerService.viewCustomersByCity(city);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
