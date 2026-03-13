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

import com.capg.springboot.model.Doctor;
import com.capg.springboot.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	DoctorService service;
	
	@PostMapping("/add")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return service.addDoctor(doctor);
    }

    @GetMapping("/getall")
    public List<Doctor> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{doctorId}")
    public Doctor getById(@PathVariable int doctorId) {
        return service.getById(doctorId);
    }

    @PutMapping("/update/{doctorId}")
    public Doctor updateById(@PathVariable int doctorId, @RequestBody Doctor doctor) {
        return service.updateById(doctorId, doctor);
    }

    @DeleteMapping("/delete/{doctorId}")
    public String deleteById(@PathVariable int doctorId) {
        return service.deleteById(doctorId);
    }
}
