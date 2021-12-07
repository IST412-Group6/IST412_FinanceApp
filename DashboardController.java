package com.example.financeapp.controller;

import com.example.financeapp.model.Loan;
import com.example.financeapp.model.User;
import com.example.financeapp.repository.*;
import com.example.financeapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

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


        HttpSession session = request.getSession();
        String checkSession = String.valueOf(
                request.getSession().getAttribute("userid"));
        model.addAttribute("Session", checkSession);
        return "loanapplication";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        String checkSession = String.valueOf(
                request.getSession().getAttribute("userid"));
        model.addAttribute("Session", checkSession);
        //add additional model attributes here for dashboard template
        User user = userService.getUserByUserId(checkSession);
        String userName = user.getUserFirstName() + " " + user.getUserLastName();
        model.addAttribute("userName", userName);
        model.addAttribute("userNum", user.getUserNum());
        model.addAttribute("userEmail", user.getUserEmail());
        model.addAttribute("userPhone", user.getUserPhone());
        model.addAttribute("userFirstName", user.getUserFirstName());
        model.addAttribute("listLoans", loanService.getAllLoansByUser(checkSession));

        return "customerMain";
    }
    @GetMapping("/edit_account")
    public String editAcc(Locale locale, Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("userid") != null){
            String checkSession = String.valueOf(
                    request.getSession().getAttribute("userid"));
            model.addAttribute("Session", checkSession);
        }
        return "edit_account";
    }
}

