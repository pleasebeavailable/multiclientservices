package com.example.multiclientservice.repository.model.signup;

public class SignUpRequest {

    private String username;
    private boolean admin;
    private String email;
    private String password;
    private String role;

    public SignUpRequest(String username, boolean admin, String email, String password, String role) {
        this.username = username;
        this.admin = admin;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
