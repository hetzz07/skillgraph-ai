package com.skillgraph.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AIRecommendationService {

    public List<String> generateRecommendations(
            List<String> skills,
            List<String> missingSkills){

        List<String> recommendations = new ArrayList<>();

        if(missingSkills.contains("Spring Boot"))
            recommendations.add("Learn Spring Boot and build REST APIs.");

        if(missingSkills.contains("Angular"))
            recommendations.add("Build one Angular CRUD project.");

        if(missingSkills.contains("Git"))
            recommendations.add("Use GitHub for every project.");

        if(missingSkills.contains("Docker"))
            recommendations.add("Containerize your Spring Boot application.");

        if(missingSkills.contains("AWS"))
            recommendations.add("Deploy your project on AWS.");

        if(skills.contains("Java"))
            recommendations.add("Practice Java interview questions daily.");

        if(skills.contains("SQL"))
            recommendations.add("Solve SQL queries on LeetCode.");

        recommendations.add("Practice DSA every day.");
        recommendations.add("Improve Resume with measurable projects.");
        recommendations.add("Build one Full Stack Project.");

        return recommendations;
    }

}