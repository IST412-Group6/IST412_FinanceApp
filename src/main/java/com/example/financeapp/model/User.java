package com.example.financeapp.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "user")
@AttributeOverrides({
        @AttributeOverride(name = "userNum", column = @Column(name = "customer_num")),
        @AttributeOverride(name = "userId", column = @Column(name = "user_id")),
        @AttributeOverride(name = "userPassword", column = @Column(name = "user_password"))
})
public class User extends UserSuper implements Serializable {


    @Column(name = "user_first_name")
    private String userFirstName;

    @Column(name = "user_last_name")
    private String userLastName;

    @Column(name = "user_email")
    @Email(message="Please enter a valid email address")
    private String userEmail;

    @Column(name = "user_phone")
    @Size(min=10, max=10, message="Please enter a valid phone number with no dashes")
    private String userPhone;

    @Column(name = "user_address")
    private String userAddress;

    //user will have account(s)
    @OneToMany()
    @JoinTable(name = "user_account",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "accountId")})


    public Set<BankAccount> bankAccounts = new HashSet<>();


    public String getUserFirstName() { return userFirstName; }

    public void setUserFirstName(String username) { this.userFirstName = username; }

    public String getUserLastName() { return userLastName; }

    public void setUserLastName(String username) { this.userLastName = username; }

    public String getUserEmail() { return userEmail; }

    public void setUserEmail(String email) { this.userEmail = email; }

    public String getUserPhone() { return userPhone; }

    public void setUserPhone(String phone) {this.userPhone = phone; }

    public String getUserAddress() { return userAddress; }

    public void setUserAddress(String address) { this.userAddress = address; }
}
