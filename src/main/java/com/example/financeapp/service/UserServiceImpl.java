package com.example.financeapp.service;

import com.example.financeapp.model.User;
import com.example.financeapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public String authenticateUser(Long userID, String userPassword) {
    String result=null;
        User user = userRepository.getById(userID);
    if (user.getUserPassword().equals(userPassword)){
        result =  "o";
        } else{
        result = "x";
    }
     return result;
    }


    @Override
    public User getUserById(Long userId) {
        return null;
    }
}
