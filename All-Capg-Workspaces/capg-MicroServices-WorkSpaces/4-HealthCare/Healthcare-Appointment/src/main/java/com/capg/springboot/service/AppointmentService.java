package com.capg.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.springboot.client.DoctorClient;
import com.capg.springboot.client.PatientClient;
import com.capg.springboot.dao.AppointmentDAO;
import com.capg.springboot.dto.AppointmentDTO;
import com.capg.springboot.model.Appointment;
import com.capg.springboot.model.Doctor;
import com.capg.springboot.model.Patient;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentDAO dao;
	
	@Autowired
	PatientClient patientClient;
	
	@Autowired
	DoctorClient doctorClient;

	
	public List<Appointment> getAll() {
		return dao.findAll();
	}
	
	
	public AppointmentDTO bookAppointment(Appointment appointment) {

	    AppointmentDTO dto = new AppointmentDTO();

	    Patient patient = patientClient.getById(appointment.getPatientId());
	    Doctor doctor = doctorClient.getById(appointment.getDoctorId());
	    dto.setPatient(patient);
        dto.setDoctor(doctor);

	    if (patient != null && doctor != null) {
	    	
	    	appointment.setStatus("BOOKED");
	    	Appointment saved = dao.save(appointment);
	        dto.setAppointment(saved);
	        dto.setBookingStatus("BOOKED SUCCESSFULLY");

	    } 
	    else {
	    	
	    	appointment.setStatus("BOOKING FAILED");
	    	Appointment saved = dao.save(appointment);
	        dto.setAppointment(saved);
	        dto.setBookingStatus("BOOKING FAILED");

	    }

	    return dto;
	}
}
