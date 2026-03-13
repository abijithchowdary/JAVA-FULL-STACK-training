package com.capg.demat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.demat.entity.DematAccount;
import com.capg.demat.repository.DematRepository;

@Service
public class DematServiceImpl implements DematService {

    @Autowired
    private DematRepository dematRepository;

    @Override
    public DematAccount createAccount(DematAccount account) {
        account.setStatus("Active");
        return dematRepository.save(account);
    }

    @Override
    public DematAccount getAccountById(Long accountId) {
        return dematRepository.findById(accountId).orElse(null);
    }

    @Override
    public List<DematAccount> getAllAccounts() {
        return dematRepository.findAll();
    }

    @Override
    public List<DematAccount> getAccountsByCustomerId(Long customerId) {
        return dematRepository.findByCustomerId(customerId);
    }

    @Override
    public DematAccount updateAccountStatus(Long accountId, String status) {
        DematAccount account = dematRepository.findById(accountId).orElse(null);
        if (account != null) {
            account.setStatus(status);
            return dematRepository.save(account);
        }
        return null;
    }

    @Override
    public void deleteAccount(Long accountId) {
        dematRepository.deleteById(accountId);
    }
}