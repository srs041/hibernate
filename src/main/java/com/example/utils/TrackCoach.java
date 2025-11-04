package com.example.utils;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Lazy
//@Primary--multiple primary not possible
public class TrackCoach implements Coach{
    public TrackCoach() {
        System.out.println("Constructor :  "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Running for 30 minutes";
    }
}
