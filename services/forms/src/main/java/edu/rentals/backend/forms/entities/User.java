package edu.rentals.backend.forms.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USERS", indexes = {@Index(columnList = "USER_ID")})
public class User {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Getter
    @Setter
    @Column(name = "USER_ID", nullable = false, updatable = false)
    private String userId;

    @Getter
    @Setter
    @Column(name = "USER_FIRST_NAME", nullable = false)
    private String userFirstName;

    @Getter
    @Setter
    @Column(name = "USER_EMAIL", nullable = false)
    private String userEmail;

    @Getter
    @Setter
    @Column(name = "USER_PHONE_NUMBER", nullable = false)
    private String userPhoneNumber;

    @Getter
    @Setter
    @Column(name = "USER_TYPE", nullable = false)
    private String userType;

    public User(String userId, String userFirstName, String userEmail, String userPhoneNumber, String userType) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.userType = userType;
    }

    public User() {

    }
}
