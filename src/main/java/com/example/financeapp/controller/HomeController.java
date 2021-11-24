package com.example.financeapp.controller;

import java.util.Locale;

import com.example.financeapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class HomeController {



    @GetMapping("/home")
    public String home(Locale locale, Model model) {

        return "home";
    }

    @GetMapping("/join")
    public String join (Model model){
        //create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "join_form";
    }

    @GetMapping("/login")
    public String login(){
        return "login_form";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "customerMain";
    }

}

