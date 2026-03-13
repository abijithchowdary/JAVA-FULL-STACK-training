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
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.model.Patient;
import com.capg.springboot.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	PatientService service;
	
	@PostMapping("/add")
	public Patient addPatient(@RequestBody Patient patient) {
		return service.addPatient(patient);
	}
	
	@GetMapping("/getall")
	public List<Patient> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/get/{patientId}")
	public Patient getById(@PathVariable int patientId) {
		return service.getById(patientId);
	}
	
	@PutMapping("/update/{patientId}")
	public Patient updateById(@PathVariable int patientId , @RequestBody Patient patient) {
		return service.updateById(patientId, patient);
	}
	
	@DeleteMapping("/delete/{patientId}")
	public String deleteById(@PathVariable int patientId) {
		return service.deleteById(patientId);
	}
}
