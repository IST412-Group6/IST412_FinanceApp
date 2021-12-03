package com.example.financeapp.controller;

import com.example.financeapp.repository.UserRepository;
import com.example.financeapp.service.EmployeeService;
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

    UserRepository userRepository;

    UserService userService;

    EmployeeService empService;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setEmpService(EmployeeService empService) { this.empService = empService; }

    @PostMapping("/loginAut")
    public String loginAut(Model model, HttpServletRequest request,
                           @RequestParam(value = "userId")  String userId,
                           @RequestParam("userPassword") String userPassword){

      String landPage= null;
      boolean LoginResult = userService.authenticateUser(userId, userPassword);
      if (LoginResult == false) {
          LoginResult = empService.authenticateEmp(userId, userPassword);
        }
      System.out.println(LoginResult);

    if (LoginResult == true){

        HttpSession session = request.getSession();
        session.setAttribute("userid", userId);
        String checkSession = String.valueOf(
                request.getSession().getAttribute("userid"));
        model.addAttribute("Session", checkSession);
        landPage = "customerMain";
    } else if (LoginResult == false) {
        landPage = "login_form";
    }

    return landPage;
    }
}
