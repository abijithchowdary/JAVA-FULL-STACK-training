package com.capg.spring;

import java.io.Serializable;

public class StudentBean implements Serializable{
	
	String name;
	int regNo;
	String branch;
	String email;
	
	StudentBean(){
		
	}
	
	public StudentBean(String name, int regNo, String branch, String email) {
		super();
		this.name = name;
		this.regNo = regNo;
		this.branch = branch;
		this.email = email;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRegNo() {
		return regNo;
	}

	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", regNo=" + regNo + ", branch=" + branch + ", email=" + email + "]";
	}
	
	
}
