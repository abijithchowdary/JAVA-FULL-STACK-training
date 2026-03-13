package com.capg.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DematAccount {

    @Id
    private Long accountId;

    private Long customerId;

    private String accountNumber;

    private String brokerName;

    private String status;
    
    public DematAccount() {
    	
    }

	public DematAccount(Long accountId, Long customerId, String accountNumber, String brokerName, String status) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.brokerName = brokerName;
		this.status = status;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
