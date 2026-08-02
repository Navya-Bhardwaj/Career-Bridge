package com.careerbridge.mapper;

import com.careerbridge.dto.UserRegistrationDTO;
import com.careerbridge.entity.User;
import com.careerbridge.enums.AccountStatus;
import com.careerbridge.enums.Role;
public class UserMapper 
{
    public static User toEntity(UserRegistrationDTO dto)
    {
        return User.builder()
                    .firstName(dto.getFirstName())
                    .lastName(dto.getLastName())
                    .email(dto.getEmail())
                    .password(dto.getPassword())
                    .phoneNumber(dto.getPhoneNumber())
                    .role(Role.CANDIDATE)
                    .accountStatus(AccountStatus.ACTIVE)
                    .build();

    }


}
