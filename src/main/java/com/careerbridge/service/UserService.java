package com.careerbridge.service;
import com.careerbridge.entity.User;
import com.careerbridge.dto.UserRegistrationDTO;
import com.careerbridge.dto.LoginRequestDTO;
public interface UserService 
{
    User registerUser(UserRegistrationDTO userRegistrationDTO);
    String loginUser(LoginRequestDTO loginRequestDTO);
}
