package edu.rentals.backend.register.api;

public class PatchUserByIdResponse {

    private String userId;

    public PatchUserByIdResponse(String userId) {
        this.userId = userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
