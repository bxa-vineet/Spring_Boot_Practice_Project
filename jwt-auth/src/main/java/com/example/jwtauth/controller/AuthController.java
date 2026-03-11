package com.example.jwtauth.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.jwtauth.dto.*;
import com.example.jwtauth.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public AuthResponse signup(@Valid @RequestBody SignupRequest request){
        return authService.signup(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request){
        return authService.login(request);
    }
}