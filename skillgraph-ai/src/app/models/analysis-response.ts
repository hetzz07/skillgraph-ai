export interface AnalysisResponse {
  skills: string[];
  missingSkills: string[];
  learningRoadmap: string[];
  interviewQuestions: string[];
  aiRecommendations: string[];
  skillGraph: any;
  companyMatches: any[];
  resumeScore: number;
  recommendedCompany: string;
  matchScore: number;
  aiInsight: any;
}