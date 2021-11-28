package com.example.financeapp.controller;

import com.example.financeapp.model.Loan;
import com.example.financeapp.model.User;
import com.example.financeapp.repository.*;
import com.example.financeapp.service.*;
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
    private LoanRepository loanRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;
   // @Autowired
  //  private LoanService loanService;

    //these values will come from loan class
    //currApp = loanStatus
    //currAppDate =
    //currAppType = loanType
    //currAppDuration = loanDuration
    //loan amount


    //need to make sure that this gets associated with the correct user
    //when new application button clicked, get loan application form
    @GetMapping("/loanApp")
    public String newLoan(Model model) {
        //create model attribute to bind form data
        Loan loan = new Loan();
        model.addAttribute("loan", loan);
        return "loanapplication";
    }


}

