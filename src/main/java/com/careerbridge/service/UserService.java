package com.careerbridge.service;
import com.careerbridge.entity.User;
import com.careerbridge.dto.UserRegistrationDTO;
public interface UserService 
{
    User registerUser(UserRegistrationDTO userRegistrationDTO);

}
