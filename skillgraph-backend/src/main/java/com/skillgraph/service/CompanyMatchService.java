package com.skillgraph.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skillgraph.dto.CompanyMatchResponse;

@Service
public class CompanyMatchService {

    public List<CompanyMatchResponse> generateMatches(List<String> userSkills) {

        List<CompanyMatchResponse> matches = new ArrayList<>();

        matches.add(createCompany(
                "Capgemini",
                Arrays.asList("Java", "SQL", "Spring Boot", "Git"),
                userSkills));

        matches.add(createCompany(
                "Infosys",
                Arrays.asList("Java", "Angular", "SQL", "HTML", "CSS"),
                userSkills));

        matches.add(createCompany(
                "TCS",
                Arrays.asList("Java", "Spring Boot", "MySQL", "Git"),
                userSkills));

        matches.add(createCompany(
                "Accenture",
                Arrays.asList("Java", "Spring Boot", "Angular", "Docker", "AWS"),
                userSkills));

        matches.add(createCompany(
                "Wipro",
                Arrays.asList("Java", "SQL", "Git", "REST API"),
                userSkills));

        matches.add(createCompany(
                "Cognizant",
                Arrays.asList("Java", "Spring Boot", "SQL", "Angular"),
                userSkills));

        return matches;
    }

    private CompanyMatchResponse createCompany(
            String company,
            List<String> requiredSkills,
            List<String> userSkills) {

        List<String> missing = new ArrayList<>();

        int matched = 0;

        for (String skill : requiredSkills) {

            if (userSkills.stream().anyMatch(s -> s.equalsIgnoreCase(skill))) {
                matched++;
            } else {
                missing.add(skill);
            }

        }

        int score = (matched * 100) / requiredSkills.size();

        return new CompanyMatchResponse(company, score, missing);
    }
}