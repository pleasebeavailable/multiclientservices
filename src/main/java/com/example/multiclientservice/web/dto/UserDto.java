package com.example.multiclientservice.web.dto;

import com.example.multiclientservice.repository.model.Job;
import com.example.multiclientservice.repository.model.Role;

import javax.persistence.*;
import java.util.Collection;

public class UserDto {

    private long id;

    private String username;

    private String password;

    private String email;

    private int active;

    private Collection<Role> roles;

    private Job job;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
