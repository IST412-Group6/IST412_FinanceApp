package com.example.financeapp.repository;

import com.example.financeapp.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Override
    Optional<Loan> findById(Long id);
    List<Loan> findAll();
}
