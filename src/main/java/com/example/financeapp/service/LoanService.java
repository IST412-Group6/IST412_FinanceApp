package com.example.financeapp.service;

import com.example.financeapp.model.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanService {
    List<Loan> getAllLoans();

    List<Loan> getAllLoansByUser(String userId);

    Loan getLoanById(Long loanNum);

    void submitLoan(Loan loan);


    Page<Loan> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


}
