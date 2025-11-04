package com.example.demo.rest;

import com.example.utils.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    private Coach coach;
   // private Coach anothercoach;

    //constructor injection
    @Autowired
    public DemoRestController(
            @Qualifier("Aquatic") Coach coach//
            // ,@Qualifier("cricketCoach") Coach anothercoach
    ) {
        System.out.println("Constructor : " + getClass().getSimpleName());
      //  this.anothercoach = anothercoach;
        this.coach = coach;
    }

    //setter injection-insted of traditional; setter method any name is fine
//    @Autowired
//    public void doStuff(@Qualifier("trackCoach") Coach coach) {
//        this.coach = coach;
//    }

    @GetMapping("/")
    public String home() {
        return "Home";
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

//    @GetMapping("/scope")
//    public String checkScope() {
//        return "Check Bean scope "+(coach==anothercoach);
//    }


}
