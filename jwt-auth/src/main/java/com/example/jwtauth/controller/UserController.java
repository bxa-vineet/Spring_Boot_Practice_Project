package com.example.jwtauth.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/profile")
    public String userProfile(){
        return "User profile accessed";
    }

    @GetMapping("/admin")
    public String adminAccess(){
        return "Admin access granted";
    }
}