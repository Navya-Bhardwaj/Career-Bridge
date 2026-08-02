package com.careerbridge.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@Getter
@AllArgsConstructor
@Builder
public class ApiResponse 
{
    private String message;
    private int status;
    private String timestamp;

}
