package com.skillgraph.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skillgraph.model.CompanySkill;
import com.skillgraph.repository.CompanySkillRepository;

@Service
public class MatchingService {

    private final CompanySkillRepository companySkillRepository;

    public MatchingService(CompanySkillRepository companySkillRepository) {
        this.companySkillRepository = companySkillRepository;
    }

    public List<String> getMissingSkills(String companyName, List<String> resumeSkills) {

    	List<CompanySkill> companySkills =
    	        companySkillRepository.findByCompanyName(companyName);

    	System.out.println("Company Skills = " + companySkills);

    	List<String> resumeSkillNames = new ArrayList<>();

    	for (String skill : resumeSkills) {
    	    resumeSkillNames.add(skill.toLowerCase());
    	}

    	System.out.println("Resume Skills = " + resumeSkillNames);

    	List<String> missingSkills = new ArrayList<>();

    	for (CompanySkill companySkill : companySkills) {

    	    if (!resumeSkillNames.contains(companySkill.getSkillName().toLowerCase())) {
    	        missingSkills.add(companySkill.getSkillName());
    	    }
    	}

    	System.out.println("Missing Skills = " + missingSkills);
    	System.out.println("Company Skills : " + companySkills);
    	System.out.println("Resume Skills : " + resumeSkillNames);
    	return missingSkills;
    }

}