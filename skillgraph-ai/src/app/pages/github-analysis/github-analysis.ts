import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Sidebar } from '../../layout/sidebar/sidebar';
import { Navbar } from '../../layout/navbar/navbar';
import { GithubService, GitHubResponse } from '../../services/github.service';
@Component({ selector: 'app-github-analysis', standalone: true, imports: [CommonModule, FormsModule, Sidebar, Navbar], templateUrl: './github-analysis.html', styleUrl: './github-analysis.css' })
export class GithubAnalysis {
  username = '';
  result: GitHubResponse | null = null;
  loading = false;
  error = '';
  constructor(private githubService: GithubService) {}
  analyze(): void {
    const value = this.username.trim();
    if (!value || this.loading) { this.error = 'Enter a GitHub username.'; return; }
    this.loading = true; this.error = '';
    this.githubService.analyze(value).subscribe({ next: r => { this.result = r; this.loading = false; }, error: e => { this.loading = false; this.error = e?.error || `Could not analyze GitHub profile (HTTP ${e?.status || 'unknown'}).`; } });
  }
}
