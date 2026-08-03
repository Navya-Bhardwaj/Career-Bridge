package com.careerbridge.exception;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.careerbridge.dto.ApiResponse;
import java.time.LocalDateTime;
import com.careerbridge.exception.PhoneNumberAlreadyExistsException;
@RestControllerAdvice
public class GlobalExceptionHandler 
{
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiResponse> handleEmailAlreadyExistsException( EmailAlreadyExistsException ex)
    {
        ApiResponse response=ApiResponse.builder()
                            .message(ex.getMessage())
                            .status(HttpStatus.CONFLICT.value())
                            .timestamp(LocalDateTime.now().toString())
                            .build();
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(PhoneNumberAlreadyExistsException.class)
    public ResponseEntity <ApiResponse> handlePhoneNumberAlreadyExistsException( PhoneNumberAlreadyExistsException ex)
    {
        ApiResponse response = ApiResponse.builder()
                            .message(ex.getMessage())
                            .status(HttpStatus.CONFLICT.value())
                            .timestamp(LocalDateTime.now().toString())
                            .build();
        
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


}
