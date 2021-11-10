package com.example.financeapp.controller;

import com.example.financeapp.model.User;
import com.example.financeapp.repository.*;
import com.example.financeapp.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class JoinController {
    private static final Logger log = LoggerFactory.getLogger(JoinController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;



// Method to get user input from the Join Form and add new user to database
    @PostMapping("/join/newMember")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }


}
