package com.capg.customer.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.customer.entity.DematAccount;

@FeignClient(name = "DematAccountService")
public interface DematAccountClient {
	
	@GetMapping("/demat/customer/{customerId}")
	public List<DematAccount> getAllDematAccount(@PathVariable long customerId);
}
