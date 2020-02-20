package com.example.multiclientservice.repository.model.signup;

public class SignUpRequest {

    private String username;
    private boolean merchant;
    private String email;
    private String password;
    private String role;

    public SignUpRequest(String username, boolean merchant, String email, String password, String role) {
        this.username = username;
        this.merchant = merchant;
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

    public boolean isMerchant() {
        return merchant;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
