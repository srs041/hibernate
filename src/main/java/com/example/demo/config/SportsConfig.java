package com.example.demo.config;

import com.example.utils.Coach;
import com.example.utils.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

    @Bean("Aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }



}
