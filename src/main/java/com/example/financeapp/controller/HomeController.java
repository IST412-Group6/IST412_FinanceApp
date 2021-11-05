package com.example.financeapp.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)

    @GetMapping("/home")
    public String home(Locale locale, Model model) {

        return "home";
    }

    @GetMapping("/join")
    public String join (){
        return "join_form";
    }

    @GetMapping("/login")
    public String login(){
        return "login_form";
    }
}
