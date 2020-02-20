package com.example.multiclientservice.service;

import com.example.multiclientservice.repository.model.login.JwtRequest;
import com.example.multiclientservice.repository.model.signup.SignUpRequest;
import org.springframework.http.ResponseEntity;

public interface IAuthService {

    ResponseEntity<?> authenticate(JwtRequest authenticationRequest) throws Exception;

    ResponseEntity<?> register(SignUpRequest signUpRequest);

}
