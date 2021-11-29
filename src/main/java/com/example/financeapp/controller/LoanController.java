package com.example.financeapp.controller;

import com.example.financeapp.model.Loan;
import com.example.financeapp.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class LoanController {
    @Autowired
    private LoanService loanService;

    @RequestMapping(value = "/LoanForm")
    public String LoanForm(Model model) {
        model.addAttribute("listCourses", loanService.getAllLoans());
        return "LoanForm";
    }

    @GetMapping("/showLoanForm")
    public String showLoanForm(Model model) {
        Loan loan = new Loan();
        model.addAttribute("loan", loan);
        return "loan_form";

    }

    @PostMapping("/saveLoan")
    public String saveLoan(@ModelAttribute("course") Loan loan) {
        loanService.saveLoan(loan);
        return "redirect:/login";
    }

}
