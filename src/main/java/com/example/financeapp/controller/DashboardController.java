package com.example.financeapp.controller;

import com.example.financeapp.model.Loan;
import com.example.financeapp.model.User;
import com.example.financeapp.repository.AccountRepository;
import com.example.financeapp.repository.UserRepository;
import com.example.financeapp.service.AccountService;
import com.example.financeapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;

    //when new application button clicked, get loan application form
    @GetMapping("/newLoan")
    public String newLoan(Model model) {
        //create model attribute to bind form data
        Loan loan = new Loan();
        model.addAttribute("loan", loan);
        return "loanapplication";
    }
}

