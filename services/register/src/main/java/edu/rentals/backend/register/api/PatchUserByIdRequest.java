package edu.rentals.backend.register.api;

import lombok.Getter;
import lombok.Setter;

public class PatchUserByIdRequest {

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private String userFirstName;

    @Getter
    @Setter
    private String userEmail;

    @Getter
    @Setter
    private String userPhoneNumber;

    @Getter
    @Setter
    private String accountType;

    public PatchUserByIdRequest(String userId, String userFirstName, String userEmail, String userPhoneNumber, String accountType) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.accountType = accountType;
    }
}
