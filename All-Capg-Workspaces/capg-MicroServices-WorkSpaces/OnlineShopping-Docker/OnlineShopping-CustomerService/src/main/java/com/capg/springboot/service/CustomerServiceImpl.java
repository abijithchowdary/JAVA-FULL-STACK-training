package com.capg.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.springboot.dao.CustomerRepository;
import com.capg.springboot.dto.CustomerRequest;
import com.capg.springboot.dto.UserResponse;
import com.capg.springboot.entity.Customer;
import com.capg.springboot.exceptions.CustomerAlreadyExistsException;
import com.capg.springboot.exceptions.CustomerNotFoundException;
import com.capg.springboot.exceptions.LoginServiceException;
import com.capg.springboot.feignclient.LoginFeignClient;

import feign.FeignException;

@Service
public class CustomerServiceImpl {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	LoginFeignClient loginFeignClient;
	
	
	public Customer addCustomer(CustomerRequest request) {
		
		if (customerRepository.existsByEmail(request.getEmail())) {
            throw new CustomerAlreadyExistsException(
                "Customer already registered with email: " + request.getEmail()
            );
		}
        
        
     // ── STEP 2: Try to create User in Login Service ──
        // Three possible outcomes:
        // A → User created successfully → get new userId
        // B → Email already exists in Login Service → get existing userId
        // C → Login Service is down → throw error
        
        UserResponse userResponse;
        
        Map<String, String> userDetails = new HashMap<>();
        userDetails.put("email", request.getEmail());
        userDetails.put("password", request.getPassword());
        userDetails.put("role",
            request.getRole() != null ? request.getRole() : "CUSTOMER"
        );
        
        
        try {
        	// Outcome A — User does not exist in Login Service
            // Login Service creates new User and returns it with userId
        	userResponse = loginFeignClient.createUser(userDetails);
        }
        catch(FeignException.Conflict e) {
        	// Outcome B — Email ALREADY EXISTS in Login Service (409 Conflict)
            // Your correct thinking — don't fail here!
            // Instead fetch the existing user and use their userId
            // This handles the inconsistent state gracefully
        	try {
        		userResponse = loginFeignClient.getUserByEmail(request.getEmail());
        	}
        	catch (FeignException fetchException) {
                throw new LoginServiceException(
                    "Email exists in Login Service but could not fetch user: "
                    + fetchException.getMessage()
                );
            }
        }
        catch (FeignException e) {
            // Outcome C — Login Service is down or any other error
            throw new LoginServiceException(
                "Login Service unavailable: " + e.getMessage()
            );
        }
        
     // ── STEP 3: Save Customer with userId ──
        Customer customer = new Customer(
        		request.getFirstName(),
                request.getLastName(),
                request.getMobileNumber(),
                request.getEmail(),
                request.getCity(),
                request.getPincode(),
                userResponse.getUserId()
        );
        
        return customerRepository.save(customer);
	}
	
	
	public Customer updateCustomer(Customer customer) {
        customerRepository.findById(customer.getCustomerId())
            .orElseThrow(() -> new CustomerNotFoundException(
                "Customer not found with ID: " + customer.getCustomerId()
            ));

        
        return customerRepository.save(customer);
    }
	
	
	public Customer removeCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new CustomerNotFoundException(
                "Customer not found with ID: " + customerId
            ));

        customerRepository.deleteById(customerId);

        return customer;
    }
	
	
	public Customer viewCustomer(Long customerId) {
        return customerRepository.findById(customerId)
            .orElseThrow(() -> new CustomerNotFoundException(
                "Customer not found with ID: " + customerId
            ));
    }

	
    public List<Customer> viewAllCustomers() {
        return customerRepository.findAll();
    }


    public List<Customer> viewCustomersByCity(String city) {
        List<Customer> customers = customerRepository.findByCity(city);

        if (customers.isEmpty()) {
            throw new CustomerNotFoundException(
                "No customers found in city: " + city
            );
        }
        return customers;
    }
}
