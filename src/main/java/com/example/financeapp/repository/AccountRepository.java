package com.example.financeapp.repository;

import com.example.financeapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Override
    Optional<Account> findById(Long id);
    List<Account> findAll();
}
