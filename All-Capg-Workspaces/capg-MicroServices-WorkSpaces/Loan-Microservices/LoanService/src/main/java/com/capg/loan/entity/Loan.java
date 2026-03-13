package com.capg.loan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Loan {

    @Id
    private Long loanId;

    private Long customerId;

    private Double loanAmount;

    private String loanType;

    private String loanStatus;
    
    public Loan() {
    	
    }

	public Loan(Long loanId, Long customerId, Double loanAmount, String loanType, String loanStatus) {
		super();
		this.loanId = loanId;
		this.customerId = customerId;
		this.loanAmount = loanAmount;
		this.loanType = loanType;
		this.loanStatus = loanStatus;
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
    
}
