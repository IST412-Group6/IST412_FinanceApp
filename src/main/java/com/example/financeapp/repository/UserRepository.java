package com.example.financeapp.repository;

import com.example.financeapp.model.User;
import com.example.financeapp.model.UserSuper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long customerNum);
    Optional<User> findByUserId(String userId);
}
