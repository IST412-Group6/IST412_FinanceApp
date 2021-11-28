package com.example.financeapp.repository;

import com.example.financeapp.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<BankAccount, Long> {
    @Override
    Optional<BankAccount> findById(Long id);
    List<BankAccount> findAll();
}
