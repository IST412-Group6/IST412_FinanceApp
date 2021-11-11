package com.example.financeapp.controller;

import com.example.financeapp.repository.UserRepository;
import com.example.financeapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;



    @PostMapping("/loginAut")
    public String loginAut(Model model, HttpServletRequest request,
                           @RequestParam(value = "userId")  String userId,
                           @RequestParam("userPassword") String userPassword){



      String Result = null;
      String result = null;

      Result = userService.authenticateUser(userId, userPassword);

      System.out.println(Result);

    if (Result =="o"){

        HttpSession session = request.getSession();
        session.setAttribute("userid", userId);
        String checkSession = String.valueOf(
                request.getSession().getAttribute("userid"));
        model.addAttribute("Session", checkSession);
         result = "/home";
    } else if (Result =="x") {
         result = "/login_form";
    }

    return result;
    }
}
