package com.capg.loan.service;

import java.util.List;

import com.capg.loan.entity.Loan;

public interface LoanService {

    Loan applyLoan(Loan loan);

    Loan getLoanById(Long loanId);

    List<Loan> getAllLoans();

    List<Loan> getLoansByCustomerId(Long customerId);

    Loan updateLoanStatus(Long loanId, String status);

    void deleteLoan(Long loanId);
}