package com.example.jwtauth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jwtauth.dto.*;
import com.example.jwtauth.model.*;
import com.example.jwtauth.repository.UserRepository;
import com.example.jwtauth.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse signup(SignupRequest request){

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user.getUsername());

        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request){

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();

        // Check password
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user.getUsername());

        return new AuthResponse(token);
    }
}