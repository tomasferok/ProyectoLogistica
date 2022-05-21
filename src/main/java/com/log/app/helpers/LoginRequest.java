package com.log.app.helpers;

public class LoginRequest {
    public String email;
    public String password;

    LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}