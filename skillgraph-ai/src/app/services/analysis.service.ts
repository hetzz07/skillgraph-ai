import { Injectable } from '@angular/core';
import { AnalysisResponse } from '../models/analysis-response';

const STORAGE_KEY = 'skillgraph.analysis';

@Injectable({ providedIn: 'root' })
export class AnalysisService {
  private analysis: AnalysisResponse | null = this.load();

  setAnalysis(response: AnalysisResponse): void {
    this.analysis = response;
    if (typeof window !== 'undefined') {
      sessionStorage.setItem(STORAGE_KEY, JSON.stringify(response));
    }
  }

  getAnalysis(): AnalysisResponse | null {
    return this.analysis;
  }

  clearAnalysis(): void {
    this.analysis = null;
    if (typeof window !== 'undefined') sessionStorage.removeItem(STORAGE_KEY);
  }

  hasAnalysis(): boolean { return !!this.analysis; }

  private load(): AnalysisResponse | null {
    if (typeof window === 'undefined') return null;
    try {
      const raw = sessionStorage.getItem(STORAGE_KEY);
      return raw ? JSON.parse(raw) as AnalysisResponse : null;
    } catch {
      return null;
    }
  }
}
