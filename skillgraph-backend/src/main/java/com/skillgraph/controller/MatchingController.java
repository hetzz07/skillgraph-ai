package com.skillgraph.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.skillgraph.repository.SkillRepository;
import com.skillgraph.service.MatchingService;

@RestController
public class MatchingController {
  private final MatchingService matchingService;
  private final SkillRepository skillRepository;
  public MatchingController(MatchingService matchingService, SkillRepository skillRepository) { this.matchingService = matchingService; this.skillRepository = skillRepository; }
  @GetMapping("/api/missing-skills/{companyName}")
  public List<String> getMissingSkills(@PathVariable String companyName) {
    List<String> resumeSkills = skillRepository.findAll().stream().map(s -> s.getSkillName()).toList();
    return matchingService.getMissingSkills(companyName, resumeSkills);
  }
}
