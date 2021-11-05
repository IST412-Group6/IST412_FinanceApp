package com.example.financeapp.service;

import com.example.financeapp.model.User;

//this interface contains all methods needed for Users

public interface UserService {

    // authenticate user's log in credentials
    void authenticateUser(User user);

    User getUserById(Long userId);


}
