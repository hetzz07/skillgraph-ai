package com.skillgraph.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skillgraph.dto.JobRecommendation;

@Service
public class JobRecommendationService {

    public List<JobRecommendation> recommendJobs(List<String> skills) {

        List<JobRecommendation> jobs = new ArrayList<>();

        jobs.add(createJob(
                "Capgemini",
                "Java Developer",
                Arrays.asList("Java", "Spring Boot", "SQL", "Git"),
                skills,
                "https://www.capgemini.com/careers/"
        ));

        jobs.add(createJob(
                "Infosys",
                "Spring Boot Developer",
                Arrays.asList("Java", "Spring Boot", "Hibernate", "REST API"),
                skills,
                "https://career.infosys.com/"
        ));

        jobs.add(createJob(
                "TCS",
                "Full Stack Developer",
                Arrays.asList("Java", "Angular", "Spring Boot", "MySQL"),
                skills,
                "https://www.tcs.com/careers"
        ));

        jobs.add(createJob(
                "Accenture",
                "Backend Developer",
                Arrays.asList("Java", "Spring Boot", "Microservices", "Docker"),
                skills,
                "https://www.accenture.com/in-en/careers"
        ));

        jobs.add(createJob(
                "Cognizant",
                "Software Engineer",
                Arrays.asList("Java", "SQL", "Git", "REST API"),
                skills,
                "https://careers.cognizant.com/"
        ));

        return jobs;
    }

    private JobRecommendation createJob(
            String company,
            String role,
            List<String> requiredSkills,
            List<String> userSkills,
            String applyLink) {

        List<String> missingSkills = new ArrayList<>();

        int matched = 0;

        for (String skill : requiredSkills) {

            boolean found = userSkills.stream()
                    .anyMatch(s -> s.equalsIgnoreCase(skill));

            if (found) {
                matched++;
            } else {
                missingSkills.add(skill);
            }
        }

        int matchScore =
                (matched * 100) / requiredSkills.size();

        return new JobRecommendation(
                company,
                role,
                matchScore,
                requiredSkills,
                missingSkills,
                applyLink
        );
    }

}