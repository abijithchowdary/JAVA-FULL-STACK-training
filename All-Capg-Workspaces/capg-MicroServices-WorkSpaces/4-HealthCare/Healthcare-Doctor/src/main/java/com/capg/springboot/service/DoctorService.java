package com.capg.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.springboot.dao.DoctorDAO;
import com.capg.springboot.model.Doctor;

@Service
public class DoctorService {
	
	@Autowired
	DoctorDAO dao;
	
	public Doctor addDoctor(Doctor doctor) {
        return dao.save(doctor);
    }

    public List<Doctor> getAll() {
        return dao.findAll();
    }

    public Doctor getById(int doctorId) {
        return dao.findById(doctorId).orElse(null);
    }

    public Doctor updateById(int doctorId, Doctor doctor) {

        Doctor existing = dao.findById(doctorId).orElse(null);

        if(existing != null) {

            existing.setName(doctor.getName());
            existing.setSpecialization(doctor.getSpecialization());
            existing.setHospital(doctor.getHospital());
            existing.setPhone(doctor.getPhone());

            return dao.save(existing);
        }

        return null;
    }

    public String deleteById(int doctorId) {

        if(dao.existsById(doctorId)) {
            dao.deleteById(doctorId);
            return "Doctor Deleted Successfully";
        }

        return "Doctor Not Found";
    }
}
