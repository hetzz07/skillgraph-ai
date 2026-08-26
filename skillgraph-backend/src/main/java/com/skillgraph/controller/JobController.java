package com.skillgraph.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillgraph.dto.JobRecommendation;
import com.skillgraph.repository.SkillRepository;
import com.skillgraph.service.JobRecommendationService;

@RestController
public class JobController {

    private final JobRecommendationService jobRecommendationService;
    private final SkillRepository skillRepository;

    public JobController(JobRecommendationService jobRecommendationService,
                         SkillRepository skillRepository) {

        this.jobRecommendationService = jobRecommendationService;
        this.skillRepository = skillRepository;
    }

    @GetMapping("/api/jobs")
    public List<JobRecommendation> getRecommendedJobs() {

        List<String> skills = skillRepository.findAll()
                .stream()
                .map(skill -> skill.getSkillName())
                .toList();

        return jobRecommendationService.recommendJobs(skills);

    }

}