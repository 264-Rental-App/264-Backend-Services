package edu.rentals.backend.register.api;

import lombok.Setter;

public class PostNewUserRequest {

    private String userId;

    private String userEmail;

    private String userFirstName;

    private String userPhoneNumber;

    public PostNewUserRequest(String id, String email, String firstname, String phoneNumber) {
        this.userId = id;
        this.userEmail = email;
        this.userFirstName = firstname;
        this.userPhoneNumber = phoneNumber;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserFirstName() {
        return this.userFirstName;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserPhoneNumber() {
        return this.userPhoneNumber;
    }
}
