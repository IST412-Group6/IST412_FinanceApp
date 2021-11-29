package com.example.financeapp.controller;

import com.example.financeapp.model.Loan;
import com.example.financeapp.repository.*;
import com.example.financeapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DashboardController {
    private  UserRepository userRepository;
    private AccountRepository accountRepository;
    private LoanRepository loanRepository;
    private UserService userService;
    private AccountService accountService;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setLoanRepository(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    @Autowired
    private LoanService loanService;


    //when new application button clicked, get loan application form
    @GetMapping("/loanApp")
    public String newLoan(Model model, HttpServletRequest request) {
        //create model attribute to bind form data
        Loan loan = new Loan();

        HttpSession session = request.getSession();
        String checkSession = String.valueOf(
                request.getSession().getAttribute("userid"));
        model.addAttribute("Session", checkSession);
        model.addAttribute("loan", loan);
        return "loanapplication";
    }


}

