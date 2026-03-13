package com.capg.demat.controller;

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

import com.capg.demat.entity.DematAccount;
import com.capg.demat.service.DematService;

@RestController
@RequestMapping("/demat")
public class DematController {

    @Autowired
    private DematService dematService;

    @PostMapping("/addaccount")
    public DematAccount createAccount(@RequestBody DematAccount account) {
        return dematService.createAccount(account);
    }

    @GetMapping("/getallaccounts")
    public List<DematAccount> getAllAccounts() {
        return dematService.getAllAccounts();
    }

    @GetMapping("getaccount/{id}")
    public DematAccount getAccount(@PathVariable Long id) {
        return dematService.getAccountById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<DematAccount> getAccountsByCustomer(@PathVariable Long customerId) {
        return dematService.getAccountsByCustomerId(customerId);
    }

    @PutMapping("/{id}/status")
    public DematAccount updateAccountStatus(@PathVariable Long id, @RequestParam String status) {
        return dematService.updateAccountStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        dematService.deleteAccount(id);
    }
}