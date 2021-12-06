package com.example.financeapp.repository;

import com.example.financeapp.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Override
    Optional<Loan> findById(Long id);
    List<Loan> findAll();
    @Query(value="SELECT * FROM loan WHERE cusid = ?1", nativeQuery = true)
    List<Loan> findByUserId(String custId);

    @Query (value = "update loan set status =?1 where loan_num = ?2 and cusID = ?3", nativeQuery= true)
    @Modifying
    @Transactional
    void updateStatus(String status, Long loan_num, String cusID);

}
