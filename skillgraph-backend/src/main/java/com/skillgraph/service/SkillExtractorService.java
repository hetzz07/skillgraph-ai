package com.skillgraph.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skillgraph.model.Skill;
import com.skillgraph.repository.SkillRepository;

@Service
public class SkillExtractorService {

    private final SkillRepository skillRepository;

    public SkillExtractorService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    private static final String[] SKILLS = {
            "Java",
            "Spring",
            "Spring Boot",
            "Hibernate",
            "SQL",
            "MySQL",
            "Angular",
            "HTML",
            "CSS",
            "JavaScript",
            "Bootstrap",
            "Git",
            "GitHub",
            "Python",
            "Docker",
            "AWS",
            "Microservices",
            "REST API"
    };

    public List<String> extractSkills(String resumeText) {

        List<String> foundSkills = new ArrayList<>();

        String text = resumeText.toLowerCase();

        for (String skill : SKILLS) {

            if (text.contains(skill.toLowerCase())) {

                foundSkills.add(skill);

                if (!skillRepository.existsBySkillName(skill)) {

                    Skill newSkill = new Skill();
                    newSkill.setSkillName(skill);

                    skillRepository.save(newSkill);
                }
            }
        }

        return foundSkills;
    }
}