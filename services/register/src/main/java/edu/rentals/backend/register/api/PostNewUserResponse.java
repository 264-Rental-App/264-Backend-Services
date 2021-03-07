package edu.rentals.backend.register.api;

import lombok.Getter;
import lombok.Setter;

public class PostNewUserResponse {

    private String userId;

    public PostNewUserResponse(String userId) {
        this.userId = userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
