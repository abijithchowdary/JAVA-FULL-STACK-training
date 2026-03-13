package com.capg.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capg.customer.entity.Customer;
import com.capg.customer.entity.CustomerProfile;
import com.capg.customer.entity.DematAccount;
import com.capg.customer.entity.Loan;
import com.capg.customer.repository.CustomerRepository;
import com.capg.customer.repository.DematAccountClient;
import com.capg.customer.repository.LoanClient;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerRepository repo;
	
	private LoanClient loanClient;
	
	private DematAccountClient dematClient;
	
	public CustomerServiceImpl(CustomerRepository repo,LoanClient loanClient,DematAccountClient dematClient) {
		this.repo = repo;
		this.loanClient = loanClient;
		this.dematClient = dematClient;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return repo.save(customer);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return repo.findById(customerId).get();
	}

	@Override
	public List<Customer> getAllCustomers() {		
		return repo.findAll();
	}

	@Override
	public void deleteCustomer(int customerId) {
		repo.deleteById(customerId);
	}

	@Override
	public CustomerProfile getCutomerProfile(int customerId) {
		
		Customer customer = getCustomerById(customerId);
		
		List<Loan> loans = loanClient.getallCustomerLoans(customerId);
		
		List<DematAccount> demats = dematClient.getAllDematAccount(customerId);
		
		CustomerProfile profile = new CustomerProfile(customer,loans,demats);
		
		return profile;
	}

}
