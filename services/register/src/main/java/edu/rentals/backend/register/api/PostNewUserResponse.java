package edu.rentals.backend.register.api;

import lombok.Getter;
import lombok.Setter;

public class PostNewUserResponse {

    @Getter
    @Setter
    private String userId;

    public PostNewUserResponse(String userId) {
        this.userId = userId;
    }
}
