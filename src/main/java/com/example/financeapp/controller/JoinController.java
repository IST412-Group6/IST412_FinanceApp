package com.example.financeapp.controller;

import com.example.financeapp.model.User;
import com.example.financeapp.repository.*;
import com.example.financeapp.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@Controller
public class JoinController {
    private static final Logger log = LoggerFactory.getLogger(JoinController.class);
    private  UserRepository userRepository;

    private AccountRepository accountRepository;

    private UserService userService;

    private AccountService accountService;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
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


// Method to get user input from the Join Form and add new user to database
    @PostMapping("/join/newMember")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "join_form";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }



}
