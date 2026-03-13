package com.capg.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.springboot.model.Doctor;

@Repository
public interface DoctorDAO extends JpaRepository<Doctor , Integer> {

}
