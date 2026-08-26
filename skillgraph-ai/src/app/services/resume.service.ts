import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AnalysisResponse } from '../models/analysis-response';

@Injectable({
  providedIn: 'root'
})
export class ResumeService {

  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  uploadResume(file: File): Observable<AnalysisResponse> {

    const formData = new FormData();
    formData.append('file', file);

    return this.http.post<AnalysisResponse>(
      `${this.apiUrl}/upload`,
      formData
    );
  }
}