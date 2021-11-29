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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoanAppController {


    private LoanService loanService;

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
    public void setLoanService(LoanService loanService) {
        this.loanService = loanService;
    }
    // Method to get user input from the Loan Application Form and add new loan to database
    @PostMapping("/loanApp/newLoan")
    public String submitLoan(@ModelAttribute("loan") Loan loan, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String checkSession = String.valueOf(
                request.getSession().getAttribute("userid"));
        model.addAttribute("Session", checkSession);
        loanService.submitLoan(loan);
        return "redirect:/login";
    }
}
