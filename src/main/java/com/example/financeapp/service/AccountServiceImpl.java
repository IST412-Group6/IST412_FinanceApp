package com.example.financeapp.service;

import com.example.financeapp.model.Account;
import com.example.financeapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long accountId) {
        Optional<Account> optional = accountRepository.findById(accountId);
        Account account = null;
        if (optional.isPresent()) {
            account = optional.get();
        } else {
            throw new RuntimeException("Account not found for id : " + accountId);
        }
        return account;
    }
}
