package com.example.demo.quartz.jobs;

import org.springframework.stereotype.Component;

@Component
public class ArbitraryDependency {
    private final String label = "Arbitrary Dependency";
 
    public String toString() {
        return label;
    }
}