package com.example.financeapp.service;

import com.example.financeapp.model.Loan;

import java.util.List;

public interface LoanService {
    List<Loan> getAllLoans();

    Loan getLoanById(Long loanNum);
    
    /*void saveLoan(Loan loan);
*/
    void submitLoan(Loan loan);
}
