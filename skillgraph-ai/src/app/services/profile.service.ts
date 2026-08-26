import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface UserProfile {
  id?: number;
  fullName: string;
  email: string;
  college: string;
  branch: string;
  githubUsername: string;
}

@Injectable({ providedIn: 'root' })
export class ProfileService {
  private readonly apiUrl = 'http://localhost:8080/api/profile';
  constructor(private http: HttpClient) {}

  create(profile: UserProfile): Observable<UserProfile> {
    return this.http.post<UserProfile>(this.apiUrl, profile);
  }

  getAll(): Observable<UserProfile[]> {
    return this.http.get<UserProfile[]>(this.apiUrl);
  }

  update(id: number, profile: UserProfile): Observable<UserProfile> {
    return this.http.put<UserProfile>(`${this.apiUrl}/${id}`, profile);
  }
}
