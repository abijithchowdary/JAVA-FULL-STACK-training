package com.capg.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.springboot.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long> {
	
	// Spring generates: SELECT * FROM customers WHERE email = ?
    // Used to check duplicate email during registration
	Optional<Customer> findByEmail(String email);
	
	// Spring generates: SELECT * FROM customers WHERE email = ?
    // Used to check if email already exists
	boolean existsByEmail(String email);
	
	// Spring generates: SELECT * FROM customers WHERE city = ?
    // Admin uses this to find all customers in a city
	List<Customer> findByCity(String city);
	
	// Spring generates: SELECT * FROM customers WHERE user_id = ?
    // Used when Login Service userId is known
	Optional<Customer> findByUserId(Long userId);
}
