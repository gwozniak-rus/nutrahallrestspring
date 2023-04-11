package com.nutrahall.nutrahallrest.response;

public class UserResponse {
    private String message;

    public UserResponse(String message){
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
