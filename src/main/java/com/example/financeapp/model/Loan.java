package com.example.financeapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "loan")
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_num")
    private Long loanNum;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "loan_amount")
    private float loanAmount;

    @Column(name = "loan_duration")
    private int loanDuration;

    @Column(name = "loan_status")
    private String loanStatus;

    //User loanUser;
    // not sure how to make this association
    // I'm thinking user would have loan arraylist attribute, so one to many association?

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerNum", nullable = false)

    public Long getLoanNum() {
        return loanNum;
    }

    public void setLoanNum(Long loanNum) {
        this.loanNum = loanNum;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }
}


