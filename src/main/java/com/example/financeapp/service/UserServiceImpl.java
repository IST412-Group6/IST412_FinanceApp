package com.example.financeapp.service;

import com.example.financeapp.model.User;
import com.example.financeapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserRepository userRepository;

    //Authenticates user log in credentials (id and password)
    @Override
    public String authenticateUser(String userID, String userPassword) {
        String result = null;
        System.out.println("HERE");
        Optional<User> user = userRepository.findByUserId(userID);
        if (user.isPresent()) {
            if (user.get().getUserPassword().equals(userPassword)) {
                result = "o";
            } else {
                result = "x";
            }
        } else {result = "x";}
            return result;
        }


    @Override
    public User getUserById(Long userId) {
        Optional<User> optional = userRepository.findById(userId);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User not found for id: " + userId);
        }
        return user;
    }

    //Saves User object to Database
    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

}
