import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { Sidebar } from '../../layout/sidebar/sidebar';
import { Navbar } from '../../layout/navbar/navbar';
import { ResumeService } from '../../services/resume.service';
import { AnalysisService } from '../../services/analysis.service';
import { AnalysisResponse } from '../../models/analysis-response';

@Component({
  selector: 'app-resume-upload',
  standalone: true,
  imports: [CommonModule, Sidebar, Navbar],
  templateUrl: './resume-upload.html',
  styleUrl: './resume-upload.css'
})
export class ResumeUpload {
  selectedFile: File | null = null;
  fileName = 'No file selected';
  fileSize = '';
  uploading = false;
  dragActive = false;
  errorMessage = '';

  constructor(
    private resumeService: ResumeService,
    public analysisService: AnalysisService,
    private router: Router
  ) {}

  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;
    this.setFile(input.files?.[0] ?? null);
  }

  onDrop(event: DragEvent): void {
    event.preventDefault();
    this.dragActive = false;
    this.setFile(event.dataTransfer?.files?.[0] ?? null);
  }

  private setFile(file: File | null): void {
    this.errorMessage = '';
    if (!file) return;
    const allowed = ['application/pdf', 'application/msword', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document'];
    const extensionOk = /\.(pdf|doc|docx)$/i.test(file.name);
    if (!extensionOk && !allowed.includes(file.type)) {
      this.selectedFile = null;
      this.fileName = 'No file selected';
      this.fileSize = '';
      this.errorMessage = 'Please select a PDF, DOC or DOCX resume.';
      return;
    }
    this.selectedFile = file;
    this.fileName = file.name;
    this.fileSize = `${(file.size / 1024 / 1024).toFixed(2)} MB`;
  }

  uploadResume(): void {
    if (!this.selectedFile || this.uploading) {
      if (!this.selectedFile) this.errorMessage = 'Please select a resume first.';
      return;
    }

    this.uploading = true;
    this.errorMessage = '';
    this.resumeService.uploadResume(this.selectedFile).subscribe({
      next: (response: AnalysisResponse) => {
        this.analysisService.setAnalysis(response);
        this.uploading = false;
        this.router.navigate(['/dashboard']);
      },
      error: (error: any) => {
        this.uploading = false;
        console.error('Resume upload failed:', error);
        this.errorMessage = error?.error?.message || error?.error || `Upload failed (HTTP ${error?.status || 'unknown'}).`;
      }
    });
  }

  analyzeResume(): void { this.uploadResume(); }
}
