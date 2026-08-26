import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Sidebar } from '../../layout/sidebar/sidebar';
import { Navbar } from '../../layout/navbar/navbar';
import { AnalysisService } from '../../services/analysis.service';
@Component({ selector: 'app-company-matching', standalone: true, imports: [CommonModule, Sidebar, Navbar], templateUrl: './company-matching.html', styleUrl: './company-matching.css' })
export class CompanyMatching { constructor(public analysisService: AnalysisService) {} get analysis(){ return this.analysisService.getAnalysis(); } }
