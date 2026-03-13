package com.capg.springboot.model;

public class Doctor {


    private int doctorId;
    private String name;
    private String specialization;
    private String hospital;
    private String phone;

    public Doctor() {
    }

    public Doctor(int doctorId, String name, String specialization, String hospital, String phone) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.hospital = hospital;
        this.phone = phone;
    }

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    
}
