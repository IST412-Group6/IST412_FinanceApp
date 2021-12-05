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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("//new_application")
    public String submitLoan( @RequestParam (value = "loanType", required = true) String loanType,
                              @RequestParam (value = "appDate", required = true) String appDate,
                              @RequestParam (value = "cusID", required = true) String cusID,
                              @RequestParam (value = "cusAddress1", required = true) String cusAddress1,
                              @RequestParam (value = "cusAddress2", required = true) String cusAddress2,
                              @RequestParam (value = "cusCity", required = true) String cusCity,
                              @RequestParam (value = "cusRegion", required = true) String cusRegion,
                              @RequestParam (value = "cusZip", required = true) String cusZip,
                              @RequestParam (value = "cusState", required = true) String cusState,
                              @RequestParam (value = "elecSig", required = true) String elecSig,
                              @RequestParam (value = "cusPhone", required = true) String cucPhone,

                              @RequestParam (value = "cusEmail", required = true) String cusEmail,
                              @RequestParam (value = "status", required = true) String status

            ,      Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String checkSession = String.valueOf(
                request.getSession().getAttribute("userid"));
        model.addAttribute("Session", checkSession);



        Loan loan = new Loan();
        loan.setAppDate(appDate);
        loan.setLoanType(loanType);
        loan.setCusID(cusID);
        loan.setCusAddress1(cusAddress1);
        loan.setCusAddress2(cusAddress2);
        loan.setCusCity(cusCity);
        loan.setCusRegion(cusRegion);
        loan.setCusZip(cusZip);
        loan.setCusState(cusState);
        loan.setElecSig(elecSig);
        loan.setCusEmail(cusEmail);
        loan.setCusPhone(cucPhone);
        loan.setStatus(status);

        loanService.submitLoan(loan);
        model.addAttribute("submit", "submit");
        return "customerMain";
    }
}
