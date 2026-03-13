package com.capg.customer.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.customer.entity.Loan;

@FeignClient(name = "LoanService")
public interface LoanClient {
	
	@GetMapping("/loans/customer/{customerId}")
	public List<Loan> getallCustomerLoans(@PathVariable long customerId);
	
}
