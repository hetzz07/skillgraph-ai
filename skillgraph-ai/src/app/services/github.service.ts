import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface GitHubResponse {
  username: string;
  avatarUrl: string;
  repositories: number;
  followers: number;
  following: number;
  languages: string[];
  githubScore: number;
  suggestions: string[];
}

@Injectable({ providedIn: 'root' })
export class GithubService {
  private readonly apiUrl = 'http://localhost:8080/api/github';
  constructor(private http: HttpClient) {}
  analyze(username: string): Observable<GitHubResponse> {
    return this.http.get<GitHubResponse>(`${this.apiUrl}/${encodeURIComponent(username.trim())}`);
  }
}
