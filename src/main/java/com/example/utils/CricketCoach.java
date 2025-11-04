package com.example.utils;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("Constructor :  "+getClass().getSimpleName());
    }

    @PostConstruct
    public void init(){
        System.out.println("Init method "+ getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroy method "+ getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "Practice Batting for 15 minutes";
    }
}
