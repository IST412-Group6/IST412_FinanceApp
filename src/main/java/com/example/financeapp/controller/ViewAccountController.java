package com.example.financeapp.controller;

import com.example.financeapp.model.User;
import com.example.financeapp.repository.AccountRepository;
import com.example.financeapp.repository.UserRepository;
import com.example.financeapp.service.AccountService;
import com.example.financeapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;


@Controller
public class ViewAccountController {

    private static final Logger log = LoggerFactory.getLogger(ViewAccountController.class);
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


    @GetMapping("/view_account")
    public String ViewAccount(Locale locale, Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("userid") != null){
            String checkSession = String.valueOf(
                    request.getSession().getAttribute("userid"));
            model.addAttribute("Session", checkSession);
        }
        return "view_account";
    }
}
