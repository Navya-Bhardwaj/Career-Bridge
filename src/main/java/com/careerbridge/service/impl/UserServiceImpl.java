package com.careerbridge.service.impl;

import com.careerbridge.entity.User;
import com.careerbridge.repository.UserRepository;
import com.careerbridge.service.UserService;
import org.springframework.stereotype.Service;

import com.careerbridge.dto.LoginRequestDTO;
import com.careerbridge.dto.UserRegistrationDTO;
import com.careerbridge.mapper.UserMapper;
import com.careerbridge.exception.EmailAlreadyExistsException;
import com.careerbridge.exception.PhoneNumberAlreadyExistsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.careerbridge.security.JwtService;
import com.careerbridge.exception.InvalidCredentialsException;
@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService)
    {
        this.userRepository = userRepository;
        this.passwordEncoder= passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public User registerUser(UserRegistrationDTO userRegistrationDTO)
    {
        if (userRepository.existsByEmail( userRegistrationDTO.getEmail()))
        {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        if (userRepository.existsByPhoneNumber( userRegistrationDTO.getPhoneNumber()))
        {
            throw new PhoneNumberAlreadyExistsException("Phone number already exists");
        }
        User user= UserMapper.toEntity(userRegistrationDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Override
    public String loginUser(LoginRequestDTO loginRequestDTO)
    {
        User user= userRepository.findByEmail(loginRequestDTO.getEmail()).orElseThrow(()-> new InvalidCredentialsException("invalid email or password"));
        if(!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword()))
        {
            throw new InvalidCredentialsException("invalid email or password");
        }
        return jwtService.generateToken(user.getEmail());
    }

}
