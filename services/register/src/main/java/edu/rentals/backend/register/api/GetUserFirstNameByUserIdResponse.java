package edu.rentals.backend.register.api;

import edu.rentals.backend.register.entities.User;

public class GetUserFirstNameByUserIdResponse {

    private String userFirstName;

    public GetUserFirstNameByUserIdResponse(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUser(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUser() {
        return userFirstName;
    }
}
