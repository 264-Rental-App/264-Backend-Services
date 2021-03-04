package edu.rentals.backend.register.api;

import edu.rentals.backend.register.entities.User;

public class GetUserByUserIdResponse {

    private User user;

    public GetUserByUserIdResponse(User user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
