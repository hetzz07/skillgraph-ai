package com.skillgraph.dto;
import com.skillgraph.dto.AIInsight;
import com.skillgraph.dto.CompanyMatchResponse;
import com.skillgraph.dto.SkillGraphResponse;
import java.util.List;
import java.util.List;
import com.skillgraph.dto.CompanyMatchResponse;
public class AnalysisResponse {
	public AIInsight getAiInsight() {
	    return aiInsight;
	}

	public void setAiInsight(AIInsight aiInsight) {
	    this.aiInsight = aiInsight;
	}
	private List<CompanyMatchResponse> companyMatches;
	private AIInsight aiInsight;
	public List<CompanyMatchResponse> getCompanyMatches() {
	    return companyMatches;
	}

	public void setCompanyMatches(List<CompanyMatchResponse> companyMatches) {
	    this.companyMatches = companyMatches;
	}
	public SkillGraphResponse getSkillGraph() {
		return skillGraph;
	}

	public void setSkillGraph(SkillGraphResponse skillGraph) {
		this.skillGraph = skillGraph;
	}

	public List<String> getAiRecommendations() {
		return aiRecommendations;
	}

	public void setAiRecommendations(List<String> aiRecommendations) {
		this.aiRecommendations = aiRecommendations;
	}

	private int resumeScore;
    private List<String> aiRecommendations;
    private List<String> skills;

    private List<String> missingSkills;
  
    
    private List<String> learningRoadmap;

    private List<String> interviewQuestions;

    private String recommendedCompany;

    private int matchScore;
    private SkillGraphResponse skillGraph;
    public AnalysisResponse() {
    }

    public int getResumeScore() {
        return resumeScore;
    }

    public void setResumeScore(int resumeScore) {
        this.resumeScore = resumeScore;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(List<String> missingSkills) {
        this.missingSkills = missingSkills;
    }

    public List<String> getLearningRoadmap() {
        return learningRoadmap;
    }

    public void setLearningRoadmap(List<String> learningRoadmap) {
        this.learningRoadmap = learningRoadmap;
    }

    public List<String> getInterviewQuestions() {
        return interviewQuestions;
    }

    public void setInterviewQuestions(List<String> interviewQuestions) {
        this.interviewQuestions = interviewQuestions;
    }

    public String getRecommendedCompany() {
        return recommendedCompany;
    }

    public void setRecommendedCompany(String recommendedCompany) {
        this.recommendedCompany = recommendedCompany;
    }

    public int getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(int matchScore) {
        this.matchScore = matchScore;
    }
}