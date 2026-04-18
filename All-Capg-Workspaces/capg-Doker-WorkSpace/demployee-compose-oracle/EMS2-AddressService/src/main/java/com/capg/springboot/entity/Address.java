package com.capg.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address_table")
public class Address {
@Id
private Long id;
private String state;
private String city;
private Long pincode;
public Address() {
	
}
public Address(Long id, String state, String city, Long pincode) {
	this.id = id;
	this.state = state;
	this.city = city;
	this.pincode = pincode;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public Long getPincode() {
	return pincode;
}
public void setPincode(Long pincode) {
	this.pincode = pincode;
}

}
