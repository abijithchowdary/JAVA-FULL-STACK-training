package com.capg.springboot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.springboot.model.Doctor;

@FeignClient(name = "DOCTOR-SERVICE")
public interface DoctorClient {
	
	@GetMapping("/doctor/get/{doctorId}")
	public Doctor getById(@PathVariable int doctorId);
}


