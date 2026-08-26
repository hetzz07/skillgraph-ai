import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Sidebar } from '../../layout/sidebar/sidebar';
import { Navbar } from '../../layout/navbar/navbar';
import { AnalysisService } from '../../services/analysis.service';
@Component({ selector: 'app-interview-readiness', standalone: true, imports: [CommonModule, Sidebar, Navbar], templateUrl: './interview-readiness.html', styleUrl: './interview-readiness.css' })
export class InterviewReadiness { constructor(public analysisService: AnalysisService) {} get analysis(){ return this.analysisService.getAnalysis(); } }
