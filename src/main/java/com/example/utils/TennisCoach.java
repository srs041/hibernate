package com.example.utils;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("Constructor :  "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Tennis for 30 minutes";
    }
}
