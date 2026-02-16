package com.capg.assessment.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "AccountTransactions")
public class TransactionBean implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transId;
	
	@Column(name = "AccountNumber")
	private long accNo;
	
	@Column(name = "Statement")
	private String trans;
	
	@Column(name = "DateOfTrans")
	private Date date;
	
	public TransactionBean(){
		
	}
	

	public int getTransId() {
		return transId;
	}


	public void setTransId(int transId) {
		this.transId = transId;
	}


	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getTrans() {
		return trans;
	}

	public void setTrans(String trans) {
		this.trans = trans;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
