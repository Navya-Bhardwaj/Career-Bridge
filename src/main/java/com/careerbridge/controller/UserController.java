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

}
