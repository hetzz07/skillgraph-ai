import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Sidebar } from '../../layout/sidebar/sidebar';
import { Navbar } from '../../layout/navbar/navbar';
import { ProfileService, UserProfile } from '../../services/profile.service';
import { AnalysisService } from '../../services/analysis.service';
@Component({ selector: 'app-profile', standalone: true, imports: [CommonModule, FormsModule, Sidebar, Navbar], templateUrl: './profile.html', styleUrl: './profile.css' })
export class Profile {
  profile: UserProfile = { fullName: 'Hetal Patil', email: 'hetal@gmail.com', college: '', branch: '', githubUsername: '' };
  editing = false; saving = false; message = ''; error = '';
  constructor(private profileService: ProfileService, public analysisService: AnalysisService) { this.load(); }
  get analysis(){ return this.analysisService.getAnalysis(); }
  load(): void { this.profileService.getAll().subscribe({ next: users => { if (users.length) { this.profile = users[users.length - 1]; this.editing = false; } }, error: () => {} }); }
  save(): void { this.saving = true; this.message=''; this.error=''; const request = this.profile.id ? this.profileService.update(this.profile.id, this.profile) : this.profileService.create(this.profile); request.subscribe({ next: saved => { this.profile=saved; this.editing=false; this.saving=false; this.message='Profile saved successfully.'; }, error: e => { this.saving=false; this.error=e?.error || `Could not save profile (HTTP ${e?.status || 'unknown'}).`; } }); }
}
