import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { ProfileService, UserProfile } from '../../services/profile.service';
@Component({ selector: 'app-register', standalone: true, imports: [FormsModule, RouterLink], templateUrl: './register.html', styleUrl: './register.css' })
export class Register {
  profile: UserProfile = { fullName: '', email: '', college: '', branch: '', githubUsername: '' };
  password = ''; confirmPassword = ''; error=''; saving=false;
  constructor(private profileService: ProfileService, private router: Router) {}
  register(): void {
    if (!this.profile.fullName || !this.profile.email || !this.password) { this.error='Name, email and password are required.'; return; }
    if (this.password !== this.confirmPassword) { this.error='Passwords do not match.'; return; }
    this.saving=true; this.error='';
    this.profileService.create(this.profile).subscribe({ next: () => { this.router.navigate(['/login']); }, error: e => { this.saving=false; this.error=e?.error || `Registration failed (HTTP ${e?.status || 'unknown'}).`; } });
  }
}
