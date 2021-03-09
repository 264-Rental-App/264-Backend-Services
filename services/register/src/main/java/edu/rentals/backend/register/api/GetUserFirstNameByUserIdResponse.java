package edu.rentals.backend.register.api;

import lombok.Getter;
import lombok.Setter;

public class GetUserFirstNameByUserIdResponse {

    @Getter
    @Setter
    private String userFirstName;

    public GetUserFirstNameByUserIdResponse(String userFirstName) {
        this.userFirstName = userFirstName;
    }
}
