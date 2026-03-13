package com.capg.demat.service;

import java.util.List;

import com.capg.demat.entity.DematAccount;

public interface DematService {

    DematAccount createAccount(DematAccount account);

    DematAccount getAccountById(Long accountId);

    List<DematAccount> getAllAccounts();

    List<DematAccount> getAccountsByCustomerId(Long customerId);

    DematAccount updateAccountStatus(Long accountId, String status);

    void deleteAccount(Long accountId);
}