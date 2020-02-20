package com.example.multiclientservice.repository.model.signup;

import com.example.multiclientservice.controller.dto.UserDto;

public class MessageResponse {

    private String message;
    private UserDto userDTO;

    public MessageResponse(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
