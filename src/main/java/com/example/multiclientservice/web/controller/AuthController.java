package com.example.multiclientservice.web.controller;

import com.example.multiclientservice.repository.model.login.JwtRequest;
import com.example.multiclientservice.repository.model.signup.SignUpRequest;
import com.example.multiclientservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody JwtRequest authRequest) throws Exception {
        return authService.authenticate(authRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        return authService.register(signUpRequest);
    }
}
