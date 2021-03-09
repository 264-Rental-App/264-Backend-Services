package edu.rentals.backend.register.api;

import lombok.Getter;
import lombok.Setter;

public class GetUserInfo {

    @Getter
    @Setter
    private String userFirstName;

    @Getter
    @Setter
    private String accountType;

    public GetUserInfo(String userFirstName, String accountType) {
        this.userFirstName = userFirstName;
        this.accountType = accountType;
    }
}
