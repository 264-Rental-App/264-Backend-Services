package edu.rentals.backend.register.api;

import lombok.Getter;
import lombok.Setter;

public class PatchUserByIdResponse {

    @Getter
    @Setter
    private String userId;

    public PatchUserByIdResponse(String userId) {
        this.userId = userId;
    }
}
