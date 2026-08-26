import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Sidebar } from '../../layout/sidebar/sidebar';
import { Navbar } from '../../layout/navbar/navbar';
import { AnalysisService } from '../../services/analysis.service';
@Component({ selector: 'app-learning-roadmap', standalone: true, imports: [CommonModule, Sidebar, Navbar], templateUrl: './learning-roadmap.html', styleUrl: './learning-roadmap.css' })
export class LearningRoadmap { constructor(public analysisService: AnalysisService) {} get analysis(){ return this.analysisService.getAnalysis(); } }
