package com.careerbridge.dto;
import lombok.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistrationDTO 
{
    @NotBlank(message= "First name is required")
    @Size(max= 50, message=" first name cannot exceed 50 characters")
    private String firstName;

    @NotBlank(message="lastname is required")
    @Size(max=50 , message="last name cannot exceed 50 characters")
    private String lastName;

    @NotBlank(message="email is required")
    @Email(message="enter valid email address")
    private String email;

    @NotBlank(message="password is required")
    @Size(min = 8, max=20, message=" password must be between 8 and 20 characters")
    private String password;

    @NotBlank(message="phone number is required")
    @Pattern(
        regexp= "^[0-9]{10}$",
        message="phone number must contain exactly 10 digits"
    )
    private String phoneNumber;

}
