package com.capg.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.entity.Employee;
import com.capg.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private final EmployeeRepository emp;
	public EmployeeController(EmployeeRepository emp) {
		this.emp=emp;
	}
	@PostMapping
	public Employee save(@RequestBody Employee e) {
		return emp.save(e);
	}
	
	@GetMapping
	public List<Employee> getAll(){
		return emp.findAll();
	}
	
}
