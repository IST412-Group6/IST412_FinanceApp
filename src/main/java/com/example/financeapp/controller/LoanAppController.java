package com.example.financeapp.controller;

import com.example.financeapp.model.Loan;
import com.example.financeapp.repository.AccountRepository;
import com.example.financeapp.repository.LoanRepository;
import com.example.financeapp.repository.UserRepository;
import com.example.financeapp.service.AccountService;
import com.example.financeapp.service.LoanService;
import com.example.financeapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoanAppController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private LoanService loanService;

    // Method to get user input from the Loan Application Form and add new loan to database
    @PostMapping("/loanApp/newLoan")
    public String submitLoan(@ModelAttribute("loan") Loan loan) {
        loanService.submitLoan(loan);
        return "redirect:/login";
    }
}
