package com.example.financeapp.service;

import com.example.financeapp.model.BankAccount;

import java.util.List;

public interface AccountService {
    List<BankAccount> getAllAccounts();

    BankAccount getAccountById(Long accountId);


}
