package com.skillgraph.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class InterviewService {

    public List<String> generateQuestions(List<String> skills){

        List<String> questions = new ArrayList<>();

        for(String skill : skills){

            switch(skill){

            case "Java":

                questions.add("What is JVM?");
                questions.add("Difference between JDK and JRE?");
                questions.add("Explain OOP Concepts.");
                break;

            case "SQL":

                questions.add("What is JOIN?");
                questions.add("Difference between DELETE and TRUNCATE?");
                questions.add("What is Normalization?");
                break;

            case "Spring Boot":

                questions.add("What is Spring Boot?");
                questions.add("What is Dependency Injection?");
                questions.add("Explain Spring MVC.");
                break;

            case "Angular":

                questions.add("What is Data Binding?");
                questions.add("Explain Components.");
                questions.add("What are Services?");
                break;

            case "HTML":

                questions.add("What is Semantic HTML?");
                questions.add("Difference between div and span?");
                break;

            case "CSS":

                questions.add("Difference between Flexbox and Grid?");
                questions.add("Explain CSS Position.");
                break;

            case "JavaScript":

                questions.add("What is Closure?");
                questions.add("Difference between let, var and const?");
                break;

            }
        }

        return questions;
    }

}