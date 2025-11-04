package com.example.utils;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach() {
        System.out.println("Constructor : "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Baseball for 30 minutes";
    }
}
