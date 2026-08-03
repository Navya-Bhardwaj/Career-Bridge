package com.careerbridge.service.impl;

import com.careerbridge.entity.User;
import com.careerbridge.repository.UserRepository;
import com.careerbridge.service.UserService;
import org.springframework.stereotype.Service;
import com.careerbridge.dto.UserRegistrationDTO;
import com.careerbridge.mapper.UserMapper;
import com.careerbridge.exception.EmailAlreadyExistsException;
import com.careerbridge.exception.PhoneNumberAlreadyExistsException;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder= passwordEncoder;
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

}
