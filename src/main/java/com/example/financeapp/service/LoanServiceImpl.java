package com.example.financeapp.service;

import com.example.financeapp.model.Loan;
import com.example.financeapp.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService{

    @Autowired
    LoanRepository loanRepository;

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Loan getLoanById(Long loanNum) {
        Optional<Loan> optional = loanRepository.findById(loanNum);
        Loan loan = null;
        if (optional.isPresent()) {
            loan = optional.get();
        }
        else {
            throw new RuntimeException("Loan not found for id : " + loanNum);
        }
        return loan;
    }

    //saves loan object to database
    @Override
    public void submitLoan(Loan loan) {
        this.loanRepository.save(loan);
    }

}
