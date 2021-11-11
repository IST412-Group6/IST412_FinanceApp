package com.example.financeapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerNum;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_address")
    private String userAddress;

    //user will also have account which will be mapped similar to student to course
    @OneToMany()
    @JoinTable(name = "user_account",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "accountId")})

    public Set<Account> accounts = new HashSet<>();

    public Long getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(Long customerNum) {
        this.customerNum = customerNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() { return userName; }

    public void setUserName(String username) { this.userName = username; }

    public String getUserPassword() { return userPassword; }

    public void setUserPassword(String password) { this.userPassword = password; }

    public String getUserEmail() { return userEmail; }

    public void setUserEmail(String email) { this.userEmail = email; }

    public String getUserPhone() { return userPhone; }

    public void setUserPhone(String phone) {this.userPhone = phone; }

    public String getUserAddress() { return userAddress; }

    public void setUserAddress(String address) { this.userAddress = address; }
}
