package com.example.financeapp.service;

import com.example.financeapp.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();

    Account getAccountById(Long accountId);


}
