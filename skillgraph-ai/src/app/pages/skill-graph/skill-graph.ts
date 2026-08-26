import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Sidebar } from '../../layout/sidebar/sidebar';
import { Navbar } from '../../layout/navbar/navbar';
import { AnalysisService } from '../../services/analysis.service';

@Component({ selector: 'app-skill-graph', standalone: true, imports: [CommonModule, Sidebar, Navbar], templateUrl: './skill-graph.html', styleUrl: './skill-graph.css' })
export class SkillGraph {
  constructor(public analysisService: AnalysisService) {}
  get analysis() { return this.analysisService.getAnalysis(); }
  readonly Math = Math;
}
