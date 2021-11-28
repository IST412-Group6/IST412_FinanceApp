package com.example.financeapp.service;

import com.example.financeapp.model.BankAccount;
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
    public List<BankAccount> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public BankAccount getAccountById(Long accountId) {
        Optional<BankAccount> optional = accountRepository.findById(accountId);
        BankAccount bankAccount = null;
        if (optional.isPresent()) {
            bankAccount = optional.get();
        } else {
            throw new RuntimeException("Account not found for id : " + accountId);
        }
        return bankAccount;
    }
}
