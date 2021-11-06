package com.example.financeapp.service;

import com.example.financeapp.model.User;
import com.example.financeapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//this interface contains all methods needed for Users

public interface UserService {

    // authenticate user's log in credentials

    String authenticateUser(Long userId, String userPassword);

    User getUserById(Long userId);


}
