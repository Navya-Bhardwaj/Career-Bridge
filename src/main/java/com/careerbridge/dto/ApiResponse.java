package com.careerbridge.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
@Getter
@AllArgsConstructor
@Builder
@Data
public class ApiResponse 
{
    private String message;
    private int status;
    private String timestamp;
    private String token;

}
