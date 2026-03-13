package com.capg.customer.entity;

import java.util.List;

public class CustomerProfile {
	
	private Customer customer;
	
	private List<Loan> loans;
	
	private List<DematAccount> dematAccounts;
	
	public CustomerProfile() {
		
	}

	public CustomerProfile(Customer customer, List<Loan> loans, List<DematAccount> dematAccounts) {
		super();
		this.customer = customer;
		this.loans = loans;
		this.dematAccounts = dematAccounts;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public List<DematAccount> getDematAccounts() {
		return dematAccounts;
	}

	public void setDematAccounts(List<DematAccount> dematAccounts) {
		this.dematAccounts = dematAccounts;
	}
	
	
}
