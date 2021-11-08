package com.example.financeapp.controller;

import com.example.financeapp.model.Account;
import com.example.financeapp.repository.AccountRepository;
import com.example.financeapp.repository.UserRepository;
import com.example.financeapp.service.UserService;
import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.ManyToOne;
import java.util.Iterator;
import java.util.Objects;


@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Controller
public class CreateAccountController {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    private Model model;
    private Account account;
    private Errors bindingResult;

    @ManyToOne
    @Autowired


    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public String createAccount() {
        this.model = model;
        this.account = account;
        ModelAndView modelAndView = new ModelAndView();
        boolean accountExists = Objects.equals(accountRepository, "username");
        if (accountExists) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "Username already taken.");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("userName");
        } else {
            userService.saveUser(account);
            modelAndView.addObject("successMessage", "User has been registered.");
            modelAndView.addObject("user", new User() {
                @Override
                public boolean equals(Object another) {
                    return false;
                }

                @Override
                public String toString() {
                    return null;
                }

                @Override
                public int hashCode() {
                    return 0;
                }

                @Override
                public String getName() {
                    return null;
                }

                @Override
                public String getFullName() {
                    return null;
                }

                @Override
                public void setFullName(String s) {

                }

                @Override
                public Iterator<Group> getGroups() {
                    return null;
                }

                @Override
                public String getPassword() {
                    return null;
                }

                @Override
                public void setPassword(String s) {

                }

                @Override
                public Iterator<Role> getRoles() {
                    return null;
                }

                @Override
                public UserDatabase getUserDatabase() {
                    return null;
                }

                @Override
                public String getUsername() {
                    return null;
                }

                @Override
                public void setUsername(String s) {

                }

                @Override
                public void addGroup(Group group) {

                }

                @Override
                public void addRole(Role role) {

                }

                @Override
                public boolean isInGroup(Group group) {
                    return false;
                }

                @Override
                public boolean isInRole(Role role) {
                    return false;
                }

                @Override
                public void removeGroup(Group group) {

                }

                @Override
                public void removeGroups() {

                }

                @Override
                public void removeRole(Role role) {

                }

                @Override
                public void removeRoles() {

                }
            });
            modelAndView.setViewName("registration");

        }
        return createAccount();
    }
}