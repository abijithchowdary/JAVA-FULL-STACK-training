package com.capg.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.loan.entity.Loan;
import com.capg.loan.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/apply")
    public Loan applyLoan(@RequestBody Loan loan) {
        return loanService.applyLoan(loan);
    }

    @GetMapping("/get")
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("getloan/{id}")
    public Loan getLoan(@PathVariable Long id) {
        return loanService.getLoanById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Loan> getLoansByCustomer(@PathVariable Long customerId) {
        return loanService.getLoansByCustomerId(customerId);
    }

    @PutMapping("/{id}/status")
    public Loan updateLoanStatus(@PathVariable Long id, @RequestParam String status) {
        return loanService.updateLoanStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
    }
}
