package com.careerbridge.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.careerbridge.service.UserService;
import lombok.RequiredArgsConstructor;
import com.careerbridge.dto.UserRegistrationDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.careerbridge.dto.ApiResponse;
import java.time.LocalDateTime;
import com.careerbridge.dto.LoginRequestDTO;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController 
{
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser( @Valid @RequestBody UserRegistrationDTO userRegistrationDTO)
    {
        userService.registerUser(userRegistrationDTO);
        ApiResponse response= ApiResponse.builder()
                    .message("user registered successfully")
                    .status(HttpStatus.CREATED.value())
                    .timestamp(LocalDateTime.now().toString())
                    .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@Valid @RequestBody LoginRequestDTO loginRequestDTO)
    {
        String token = userService.loginUser(loginRequestDTO);
        ApiResponse response = ApiResponse.builder()
                    .message("login sucessful")
                    .status(HttpStatus.OK.value())
                    .timestamp(LocalDateTime.now().toString())
                    .token(token)
                    .build();
        
        return ResponseEntity.ok(response);
    }
    @GetMapping("/test")
    public ResponseEntity<String> test()
    {
        return ResponseEntity.ok("JWT authentication working!");
    }

}
