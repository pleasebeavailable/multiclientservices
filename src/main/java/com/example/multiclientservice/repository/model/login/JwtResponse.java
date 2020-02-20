package com.example.multiclientservice.repository.model.login;

import com.example.multiclientservice.controller.dto.UserDto;

import java.util.List;

public class JwtResponse {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private Long id;
    private String username;
    private boolean admin;
    private List<String> roles;

    public JwtResponse(String jwttoken, Long id, String username, boolean admin, List<String> roles) {
        this.jwttoken = jwttoken;
        this.id = id;
        this.username = username;
        this.admin = admin;
        this.roles = roles;
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
