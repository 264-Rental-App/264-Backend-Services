package edu.rentals.backend.register.api;

public class PatchUserByIdRequest {

    private String userId;

    private String userFirstName;

    private String userEmail;

    private Integer userPhoneNumber;

    public PatchUserByIdRequest(String userId, String userFirstName, String userEmail, Integer userPhoneNumber) {

        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;

    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserPhoneNumber(Integer userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Integer getUserPhoneNumber() {
        return userPhoneNumber;
    }

}