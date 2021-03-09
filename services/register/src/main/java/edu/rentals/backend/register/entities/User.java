package edu.rentals.backend.register.entities;

import javax.persistence.*;

@Entity
@Table(name = "USERS", indexes = { @Index(columnList = "USER_ID")})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "USER_ID", nullable = false, updatable = false)
    private String userId;

    @Column(name = "USER_FIRST_NAME", nullable = false)
    private String userFirstName;

    @Column(name = "USER_EMAIL", nullable = false)
    private String userEmail;

    @Column(name = "USER_PHONE_NUMBER", nullable = false)
    private String userPhoneNumber;

    @Column(name = "ACCOUNT_TYPE", nullable = false)
    private String accountType;

    public User(String userId, String userFirstName, String userEmail, String userPhoneNumber, String accountType) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.accountType = accountType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUserId(String uid) {
        this.userId = uid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserFirstName(String firstName) {
        this.userFirstName = firstName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserPhoneNumber(String phoneNumber) {
        this.userPhoneNumber = phoneNumber;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }
}
