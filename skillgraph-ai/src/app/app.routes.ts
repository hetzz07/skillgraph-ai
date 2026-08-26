import { Routes } from '@angular/router';

import { Login } from './pages/login/login';
import { Register } from './pages/register/register';
import { Dashboard } from './pages/dashboard/dashboard';
import { Profile } from './pages/profile/profile';
import { ResumeUpload } from './pages/resume-upload/resume-upload';
import { GithubAnalysis } from './pages/github-analysis/github-analysis';
import { SkillGraph } from './pages/skill-graph/skill-graph';
import { CompanyMatching } from './pages/company-matching/company-matching';
import { LearningRoadmap } from './pages/learning-roadmap/learning-roadmap';
import { AiRecommendations } from './pages/ai-recommendations/ai-recommendations';
import { InterviewReadiness } from './pages/interview-readiness/interview-readiness';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },

  { path: 'login', component: Login },
  { path: 'register', component: Register },
  { path: 'dashboard', component: Dashboard },
  { path: 'profile', component: Profile },
  { path: 'resume-upload', component: ResumeUpload },
  { path: 'github-analysis', component: GithubAnalysis },
  { path: 'skill-graph', component: SkillGraph },
  { path: 'company-matching', component: CompanyMatching },
  { path: 'learning-roadmap', component: LearningRoadmap },
  { path: 'ai-recommendations', component: AiRecommendations },
  { path: 'interview-readiness', component: InterviewReadiness },

  { path: '**', redirectTo: 'login' }
];