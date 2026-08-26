import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Sidebar } from '../../layout/sidebar/sidebar';
import { Navbar } from '../../layout/navbar/navbar';
import { AnalysisService } from '../../services/analysis.service';
@Component({ selector: 'app-ai-recommendations', standalone: true, imports: [CommonModule, Sidebar, Navbar], templateUrl: './ai-recommendations.html', styleUrl: './ai-recommendations.css' })
export class AiRecommendations { constructor(public analysisService: AnalysisService) {} get analysis(){ return this.analysisService.getAnalysis(); } }
