package com.skillgraph.controller;

import java.io.File;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.skillgraph.dto.AnalysisResponse;
import com.skillgraph.dto.CompanyMatchResponse;
import com.skillgraph.dto.SkillGraphResponse;
import com.skillgraph.repository.SkillRepository;
import com.skillgraph.service.AIInsightService;
import com.skillgraph.service.AIRecommendationService;
import com.skillgraph.service.CompanyMatchService;
import com.skillgraph.service.InterviewService;
import com.skillgraph.service.MatchingService;
import com.skillgraph.service.RoadmapService;
import com.skillgraph.service.ResumeParserService;
import com.skillgraph.service.SkillExtractorService;
import com.skillgraph.service.SkillGraphService;

@RestController
public class ResumeController {

    private final ResumeParserService parserService;
    private final SkillExtractorService skillExtractorService;
    private final MatchingService matchingService;
    private final SkillRepository skillRepository;
    private final RoadmapService roadmapService;
    private final AIInsightService aiInsightService;
    private final InterviewService interviewService;
    private final AIRecommendationService aiRecommendationService;
    private final SkillGraphService skillGraphService;
    private final CompanyMatchService companyMatchService;

    public ResumeController(
            ResumeParserService parserService,
            SkillExtractorService skillExtractorService,
            MatchingService matchingService,
            SkillRepository skillRepository,
            RoadmapService roadmapService,
            InterviewService interviewService,
            AIInsightService aiInsightService,
            CompanyMatchService companyMatchService,
            AIRecommendationService aiRecommendationService,
            SkillGraphService skillGraphService) {

        this.parserService = parserService;
        this.skillExtractorService = skillExtractorService;
        this.matchingService = matchingService;
        this.skillRepository = skillRepository;
        this.roadmapService = roadmapService;
        this.interviewService = interviewService;
        this.aiInsightService = aiInsightService;
        this.companyMatchService = companyMatchService;
        this.aiRecommendationService = aiRecommendationService;
        this.skillGraphService = skillGraphService;
    }

    @GetMapping("/api/test")
    public String test() {
        return "SkillGraph Backend Running Successfully 🚀";
    }

    @PostMapping("/api/upload")
    public ResponseEntity<?> uploadResume(
            @RequestParam("file") MultipartFile file) {

        try {

            System.out.println(
                    "User Directory = " + System.getProperty("user.dir"));

            // =========================
            // Create Upload Directory
            // =========================

            String uploadDir =
                    System.getProperty("user.dir")
                    + File.separator
                    + "uploads";

            File dir = new File(uploadDir);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            // =========================
            // Save Resume
            // =========================

            String fileName =
                    System.currentTimeMillis()
                    + "_"
                    + file.getOriginalFilename();

            File destination = new File(dir, fileName);

            System.out.println(
                    "Saving file to : "
                    + destination.getAbsolutePath());

            file.transferTo(destination);

            // =========================
            // Extract Resume Text
            // =========================

            String resumeText =
                    parserService.extractText(
                            destination.getAbsolutePath());

            // =========================
            // Clear Previous Skills
            // =========================

            skillRepository.deleteAll();

            // =========================
            // Extract Skills
            // =========================

            List<String> skills =
                    skillExtractorService.extractSkills(resumeText);

            // =========================
            // Missing Skills
            // =========================

            List<String> missingSkills =
                    matchingService.getMissingSkills(
                            "Capgemini",
                            skills);

            // =========================
            // Learning Roadmap
            // =========================

            List<String> roadmap =
                    roadmapService.generateRoadmap(
                            missingSkills);

            // =========================
            // Interview Questions
            // =========================

            List<String> interviewQuestions =
                    interviewService.generateQuestions(
                            skills);

            // =========================
            // AI Recommendations
            // =========================

            List<String> recommendations =
                    aiRecommendationService.generateRecommendations(
                            skills,
                            missingSkills);

            // =========================
            // Company Matches
            // =========================

            List<CompanyMatchResponse> companyMatches =
                    companyMatchService.generateMatches(
                            skills);

            // =========================
            // Skill Graph
            // =========================

            SkillGraphResponse graph =
                    skillGraphService.buildGraph(
                            skills);

            // =========================
            // Create Response
            // =========================

            AnalysisResponse response =
                    new AnalysisResponse();

            // =========================
            // Basic Analysis Data
            // =========================

            response.setSkills(skills);

            response.setMissingSkills(
                    missingSkills);

            response.setLearningRoadmap(
                    roadmap);

            response.setInterviewQuestions(
                    interviewQuestions);

            response.setAiRecommendations(
                    recommendations);

            response.setSkillGraph(
                    graph);

            response.setCompanyMatches(
                    companyMatches);

            // =========================
            // Resume Score
            // =========================

            int resumeScore = Math.min(100, 50 + (skills.size() * 4));
            response.setResumeScore(resumeScore);

            // =========================
            // Recommended Company
            // =========================

            String recommendedCompany = companyMatches.stream()
                    .max((a, b) -> Integer.compare(a.getMatchScore(), b.getMatchScore()))
                    .map(CompanyMatchResponse::getCompanyName)
                    .orElse("Capgemini");
            response.setRecommendedCompany(recommendedCompany);

            // =========================
            // Match Score
            // =========================

            int bestMatchScore = companyMatches.stream()
                    .mapToInt(CompanyMatchResponse::getMatchScore)
                    .max()
                    .orElse(0);
            response.setMatchScore(bestMatchScore);

            // =========================
            // AI Insight
            // =========================

            response.setAiInsight(
                    aiInsightService.generateInsight(
                            skills,
                            missingSkills,
                            response.getRecommendedCompany()
                    )
            );

            // =========================
            // Return Response
            // =========================

            return ResponseEntity.ok(response);

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .internalServerError()
                    .body(
                            "Upload Failed : "
                            + e.getMessage()
                    );
        }
    }
}