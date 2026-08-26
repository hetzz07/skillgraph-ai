package com.skillgraph.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillgraph.model.Skill;
import com.skillgraph.repository.SkillRepository;


@RestController
public class SkillController {

    private final SkillRepository skillRepository;

    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @GetMapping("/api/skills")
    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }
}