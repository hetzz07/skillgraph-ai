package com.skillgraph.dto;

import java.util.List;

public class AIInsight {

    private String bestCompany;
    private String bestRole;
    private List<String> strengths;
    private List<String> improvements;
    private String nextGoal;
    private List<String> interviewFocus;

    public AIInsight() {
    }

    public String getBestCompany() {
        return bestCompany;
    }

    public void setBestCompany(String bestCompany) {
        this.bestCompany = bestCompany;
    }

    public String getBestRole() {
        return bestRole;
    }

    public void setBestRole(String bestRole) {
        this.bestRole = bestRole;
    }

    public List<String> getStrengths() {
        return strengths;
    }

    public void setStrengths(List<String> strengths) {
        this.strengths = strengths;
    }

    public List<String> getImprovements() {
        return improvements;
    }

    public void setImprovements(List<String> improvements) {
        this.improvements = improvements;
    }

    public String getNextGoal() {
        return nextGoal;
    }

    public void setNextGoal(String nextGoal) {
        this.nextGoal = nextGoal;
    }

    public List<String> getInterviewFocus() {
        return interviewFocus;
    }

    public void setInterviewFocus(List<String> interviewFocus) {
        this.interviewFocus = interviewFocus;
    }
}