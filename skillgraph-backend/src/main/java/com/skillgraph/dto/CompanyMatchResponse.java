package com.skillgraph.dto;

import java.util.List;

public class CompanyMatchResponse {

    private String companyName;

    private int matchScore;

    private List<String> missingSkills;

    public CompanyMatchResponse() {
    }

    public CompanyMatchResponse(String companyName, int matchScore, List<String> missingSkills) {
        this.companyName = companyName;
        this.matchScore = matchScore;
        this.missingSkills = missingSkills;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(int matchScore) {
        this.matchScore = matchScore;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(List<String> missingSkills) {
        this.missingSkills = missingSkills;
    }

}