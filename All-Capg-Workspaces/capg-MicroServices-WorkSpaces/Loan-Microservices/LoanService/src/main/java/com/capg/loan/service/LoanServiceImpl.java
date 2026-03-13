package com.capg.loan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.loan.entity.Loan;
import com.capg.loan.repository.LoanRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public Loan applyLoan(Loan loan) {
        loan.setLoanStatus("Pending");
        return loanRepository.save(loan);
    }

    @Override
    public Loan getLoanById(Long loanId) {
        return loanRepository.findById(loanId).orElse(null);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public List<Loan> getLoansByCustomerId(Long customerId) {
        return loanRepository.findByCustomerId(customerId);
    }

    @Override
    public Loan updateLoanStatus(Long loanId, String status) {
        Loan loan = loanRepository.findById(loanId).orElse(null);
        if (loan != null) {
            loan.setLoanStatus(status);
            return loanRepository.save(loan);
        }
        return null;
    }

    @Override
    public void deleteLoan(Long loanId) {
        loanRepository.deleteById(loanId);
    }
}