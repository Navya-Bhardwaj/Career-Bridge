package com.careerbridge.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/recruiter")
public class RecruiterController 
{
    @GetMapping("/test")
    public String adminTest()
    {
        return "welcome recruiter!";
    }


}
