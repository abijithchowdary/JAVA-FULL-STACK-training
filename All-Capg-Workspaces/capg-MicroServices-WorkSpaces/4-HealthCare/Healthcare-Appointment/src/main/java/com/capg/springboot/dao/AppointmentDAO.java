package com.capg.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.springboot.model.Appointment;

@Repository
public interface AppointmentDAO extends JpaRepository<Appointment , Integer> {

}
