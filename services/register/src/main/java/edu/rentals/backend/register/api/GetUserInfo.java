package edu.rentals.backend.register.api;

import lombok.Getter;
import lombok.Setter;

public class GetUserInfo {

    @Getter
    @Setter
    private String userFirstName;

    @Getter
    @Setter
    private String userType;

    public GetUserInfo(String userFirstName, String userType) {
        this.userFirstName = userFirstName;
        this.userType = userType;
    }
}
