//package com.example.jwtauth.dto;
//
//import lombok.Data;
//
//@Data
//public class SignupRequest {
//
//    private String username;
//    private String email;
//    private String password;
//}
package com.example.jwtauth.dto;

import com.example.jwtauth.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignupRequest {
    @NotBlank(message = "Username is required")
    private String username;
    @Email(message = "Email must be valid")
    private String email;
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$",
            message = "Password must contain upper, lower, special character and min 8 characters"
    )
    private String password;
    private Role role;
}