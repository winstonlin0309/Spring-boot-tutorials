package com.luv2code.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component
public class CriketCoach implements Coach{
    public CriketCoach() {
        System.out.println("In Constructor: " +getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes！！！";
    }
}
