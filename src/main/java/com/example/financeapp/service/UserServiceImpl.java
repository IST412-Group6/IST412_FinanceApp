package com.example.financeapp.service;

import com.example.financeapp.model.User;
import com.example.financeapp.model.UserSuper;
import com.example.financeapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    //Authenticates user log in credentials (id and password)
    @Override
    public boolean authenticateUser(String userID, String userPassword) {
        boolean result = false;
        System.out.println("HERE");
        Optional<User> user = userRepository.findByUserId(userID);
        if (user.isPresent()) {
            if (user.get().getUserPassword().equals(userPassword)) {
                result =true;
            } else {
                result = false;
            }
        } else {result = false;}
            return result;
        }

    @Override
    public User getUserByCustomerNum(Long customerNum) {
        Optional<User> optional = userRepository.findById(customerNum);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User not found for customer number: " + customerNum);
        }
        return user;
    }

    @Override
    public User getUserByUserId(String userId) {
        Optional<User> optional = userRepository.findByUserId(userId);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User not found for id: " + userId);
        }
        return user;
    }

    @Override
    //Saves User object to database
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

}
