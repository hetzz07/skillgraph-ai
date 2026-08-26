import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Component({ selector: 'app-login', standalone: true, imports: [FormsModule, RouterLink], templateUrl: './login.html', styleUrl: './login.css' })
export class Login {
  email='admin@gmail.com'; password='admin123'; error=''; loading=false;
  constructor(private http: HttpClient, private router: Router) {}
  login(): void { this.loading=true; this.error=''; this.http.post<{token:string}>('http://localhost:8080/api/auth/login',{email:this.email,password:this.password}).subscribe({ next:r=>{ localStorage.setItem('skillgraph.token',r.token); this.loading=false; this.router.navigate(['/dashboard']); }, error:e=>{ this.loading=false; this.error=e?.status===401?'Invalid credentials. For the current backend demo use admin@gmail.com / admin123.':`Backend unavailable (HTTP ${e?.status || 'unknown'}).`; } }); }
}
