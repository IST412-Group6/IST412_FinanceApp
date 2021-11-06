package com.example.financeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {


    @GetMapping("/logout")
    public String logOut(Model model, HttpServletRequest request) {
        request.getSession().invalidate();
        request.getSession().removeAttribute("userid");
        String check = (String) request.getSession().getAttribute("userid");
        System.out.println("LogOut"+ check);
        String out = "out okay";
        model.addAttribute("out", out);

        return "/home";
    }
}
