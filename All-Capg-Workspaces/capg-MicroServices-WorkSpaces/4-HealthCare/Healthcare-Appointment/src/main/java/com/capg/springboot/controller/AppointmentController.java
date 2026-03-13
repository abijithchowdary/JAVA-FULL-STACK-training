package com.capg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.dto.AppointmentDTO;
import com.capg.springboot.model.Appointment;
import com.capg.springboot.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentService service;
	
	@GetMapping("/getall")
	public List<Appointment> getAll() {
		return service.getAll();
	}
	
	@PostMapping("/book")
	public AppointmentDTO bookAppointment(@RequestBody Appointment appointment) {
		return service.bookAppointment(appointment);
	}
}
