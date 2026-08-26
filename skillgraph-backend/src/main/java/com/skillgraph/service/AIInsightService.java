package com.skillgraph.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skillgraph.dto.AIInsight;

@Service
public class AIInsightService {

    public AIInsight generateInsight(
            List<String> skills,
            List<String> missingSkills,
            String company) {

        AIInsight insight = new AIInsight();

        // Best Company
        insight.setBestCompany(company);

        // Best Role
        if (skills.contains("Angular") && skills.contains("Spring Boot")) {

            insight.setBestRole("Full Stack Java Developer");

        } else if (skills.contains("Spring Boot")) {

            insight.setBestRole("Backend Java Developer");

        } else {

            insight.setBestRole("Software Engineer");

        }

        // Strengths
        List<String> strengths = new ArrayList<>();

        for (String skill : skills) {

            if (strengths.size() == 4)
                break;

            strengths.add(skill);

        }

        insight.setStrengths(strengths);

        // Improvements
        insight.setImprovements(missingSkills);

        // Next Goal
        if (!missingSkills.isEmpty()) {

            insight.setNextGoal(
                    "Learn " + missingSkills.get(0));

        } else {

            insight.setNextGoal(
                    "Start applying for jobs");

        }

        // Interview Focus
        List<String> interview = new ArrayList<>();

        interview.add("Core Java");

        interview.add("Spring Boot");

        interview.add("SQL");

        interview.add("REST API");

        interview.add("Angular");

        insight.setInterviewFocus(interview);

        return insight;

    }

}