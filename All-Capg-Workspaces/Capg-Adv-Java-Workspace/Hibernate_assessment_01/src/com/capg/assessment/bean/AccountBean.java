package com.capg.assessment.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Accounts")
public class AccountBean implements Serializable{
	
	@Id
	@Column(name = "AccountNumber")
	private long accNo;
	
	@Column(name = "HolderName")
	private String holderName;
	
	@Column(name = "MobileNumber")
	private long mobile;
	
	@Column(name = "AccountBalance")
	private double balance;
	
	
	public AccountBean(){
		
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
