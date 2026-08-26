package com.skillgraph.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RoadmapService {

    public List<String> generateRoadmap(List<String> missingSkills) {

        List<String> roadmap = new ArrayList<>();

        for (String skill : missingSkills) {

            switch (skill) {

                case "Spring Boot":
                    roadmap.add("Learn Spring Boot");
                    break;

                case "Git":
                    roadmap.add("Master Git & GitHub");
                    break;

                case "Angular":
                    roadmap.add("Build Angular Projects");
                    break;

                case "HTML":
                    roadmap.add("Practice HTML Layouts");
                    break;

                case "CSS":
                    roadmap.add("Learn Responsive CSS");
                    break;

                case "Bootstrap":
                    roadmap.add("Learn Bootstrap Components");
                    break;

                case "JavaScript":
                    roadmap.add("Practice JavaScript ES6");
                    break;

                case "Python":
                    roadmap.add("Learn Python Fundamentals");
                    break;

                case "SQL":
                    roadmap.add("Practice SQL Queries");
                    break;

                case "Java":
                    roadmap.add("Practice Core Java & OOP");
                    break;

                default:
                    roadmap.add("Learn " + skill);
            }
        }

        return roadmap;
    }
}