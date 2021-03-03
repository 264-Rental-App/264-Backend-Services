package edu.rentals.backend.register.api;

import lombok.Setter;

public class PostNewUserRequest {

    @Setter
    private String userId;

    @Setter
    private String userEmail;

    @Setter
    private String userFirstname;

    @Setter
    private int userPhonenumber;

    public PostNewUserRequest(String id, String email, String firstname, int phonenumber) {
        this.userId = id;
        this.userEmail = email;
        this.userFirstname = firstname;
        this.userPhonenumber = phonenumber;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public String getUserFirstname() {
        return this.userFirstname;
    }

    public int getUserPhonenumber() {
        return this.userPhonenumber;
    }
}
