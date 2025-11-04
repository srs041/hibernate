package com.example.utils;

import org.springframework.stereotype.Component;


public class SwimCoach implements  Coach{

    public SwimCoach() {
        System.out.println("Constructor :  "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as wormup.";
    }
}
