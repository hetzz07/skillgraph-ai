package com.skillgraph.dto;

import java.util.List;

public class JobRecommendation {

    private String company;

    private String role;

    private int matchScore;

    private List<String> requiredSkills;

    private List<String> missingSkills;

    private String applyLink;

    public JobRecommendation() {
    }

    public JobRecommendation(
            String company,
            String role,
            int matchScore,
            List<String> requiredSkills,
            List<String> missingSkills,
            String applyLink) {

        this.company = company;
        this.role = role;
        this.matchScore = matchScore;
        this.requiredSkills = requiredSkills;
        this.missingSkills = missingSkills;
        this.applyLink = applyLink;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(int matchScore) {
        this.matchScore = matchScore;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(List<String> missingSkills) {
        this.missingSkills = missingSkills;
    }

    public String getApplyLink() {
        return applyLink;
    }

    public void setApplyLink(String applyLink) {
        this.applyLink = applyLink;
    }
}