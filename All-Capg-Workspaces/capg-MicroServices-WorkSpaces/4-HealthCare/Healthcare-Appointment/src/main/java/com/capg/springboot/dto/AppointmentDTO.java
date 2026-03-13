package com.capg.springboot.dto;

import com.capg.springboot.model.Appointment;
import com.capg.springboot.model.Patient;
import com.capg.springboot.model.Doctor;

public class AppointmentDTO {

    private Appointment appointment;
    private Patient patient;
    private Doctor doctor;
    private String bookingStatus;

    public AppointmentDTO() {
    }

    public AppointmentDTO(Appointment appointment, Patient patient, Doctor doctor, String bookingStatus) {
        this.appointment = appointment;
        this.patient = patient;
        this.doctor = doctor;
        this.bookingStatus = bookingStatus;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

}