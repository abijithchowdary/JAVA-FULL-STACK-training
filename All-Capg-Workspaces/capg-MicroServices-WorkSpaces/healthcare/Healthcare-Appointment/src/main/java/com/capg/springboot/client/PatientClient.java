package com.capg.springboot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.springboot.model.Patient;

@FeignClient(name = "PATIENT-SERVICE")
public interface PatientClient {
	
	@GetMapping("/patient/get/{patientId}")
	public Patient getById(@PathVariable int patientId);
}
