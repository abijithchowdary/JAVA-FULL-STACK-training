package com.capg.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.springboot.dao.PatientDAO;
import com.capg.springboot.model.Patient;

@Service
public class PatientService {
	
	@Autowired
	PatientDAO dao;
	
	public Patient addPatient(Patient patient) {
		return dao.save(patient);
	}
	
	public List<Patient> getAll() {
		return dao.findAll();
	}
	
	public Patient getById(int patientId) {
		return dao.findById(patientId).orElse(null);
	}
	
	public Patient updateById(int patientId , Patient patient) {
		Patient existing = dao.findById(patientId).orElse(null);

        if(existing != null) {

            existing.setName(patient.getName());
            existing.setAge(patient.getAge());
            existing.setGender(patient.getGender());
            existing.setPhone(patient.getPhone());

            return dao.save(existing);
        }

        return null;
	}
	
	public String deleteById(int patientId) {
		if(dao.existsById(patientId)) {
            dao.deleteById(patientId);
            return "Patient Deleted Successfully";
        }

        return "Patient Not Found";
	}
}

