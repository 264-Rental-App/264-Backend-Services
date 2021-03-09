package edu.rentals.backend.register.api;

import lombok.Getter;
import lombok.Setter;

public class PostNewUserRequest {

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private String userEmail;

    @Getter
    @Setter
    private String userFirstName;

    @Getter
    @Setter
    private String userPhoneNumber;

    @Getter
    @Setter
    private String accountType;

    public PostNewUserRequest(String id, String email, String firstname, String phoneNumber, String accountType) {
        this.userId = id;
        this.userEmail = email;
        this.userFirstName = firstname;
        this.userPhoneNumber = phoneNumber;
        this.accountType = accountType;
    }
}
