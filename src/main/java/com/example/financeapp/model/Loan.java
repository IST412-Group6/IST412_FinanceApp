package com.example.financeapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "loan")
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_num")
    private Long loanNum;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "appDate")
    private String appDate;

    @Column(name = "cusID")
    private String cusID;

    @Column(name = "cusAddress1")
    private String cusAddress1;

    @Column(name = "cusAddress2")
    private String cusAddress2;

    @Column(name = "cusCity")
    private String cusCity;

    @Column(name = "cusRegion")
    private String cusRegion;

    @Column(name = "cusZip")
    private String cusZip;

    @Column(name = "cusState")
    private String cusState;

    @Column(name = "cusPhone")
    private String cusPhone;

    @Column(name = "cusEmail")
    private String cusEmail;
    @Column(name = "elecSig")
    private String elecSig;
    @Column(name = "status")
   private String status;


/*
    @ManyToOne()
    @JoinColumn(name = "customer_num", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;
*/

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

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getCusAddress1() {
        return cusAddress1;
    }

    public void setCusAddress1(String cusAddress1) {
        this.cusAddress1 = cusAddress1;
    }

    public String getCusAddress2() {
        return cusAddress2;
    }

    public void setCusAddress2(String cusAddress2) {
        this.cusAddress2 = cusAddress2;
    }

    public String getCusCity() {
        return cusCity;
    }

    public void setCusCity(String cusCity) {
        this.cusCity = cusCity;
    }

    public String getCusRegion() {
        return cusRegion;
    }

    public void setCusRegion(String cusRegion) {
        this.cusRegion = cusRegion;
    }

    public String getCusZip() {
        return cusZip;
    }

    public void setCusZip(String cusZip) {
        this.cusZip = cusZip;
    }

    public String getCusState() {
        return cusState;
    }

    public void setCusState(String cusState) {
        this.cusState = cusState;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getElecSig() {
        return elecSig;
    }

    public void setElecSig(String elecSig) {
        this.elecSig = elecSig;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
/*    public User getUser() {
        return user;
    }

    public void setUser(Optional<User> user) {
        this.user = user;
    }*/
}


