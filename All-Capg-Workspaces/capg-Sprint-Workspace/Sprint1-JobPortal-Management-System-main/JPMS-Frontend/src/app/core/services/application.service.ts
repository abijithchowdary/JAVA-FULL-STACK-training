import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {
  private apiUrl = `${environment.apiUrl}/applications`;

  constructor(private http: HttpClient) { }

  applyForJob(jobId: number, coverLetter: string, useExistingResume: boolean, existingResumeUrl: string, resume?: File): Observable<any> {
    const formData = new FormData();
    formData.append('jobId', jobId.toString());
    if (coverLetter) formData.append('coverLetter', coverLetter);
    formData.append('useExistingResume', useExistingResume.toString());
    if (existingResumeUrl) formData.append('existingResumeUrl', existingResumeUrl);
    if (resume) formData.append('resume', resume);

    return this.http.post<any>(this.apiUrl, formData);
  }

  getMyApplications(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/my-applications`);
  }

  getApplicationById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  getApplicantsForJob(jobId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/job/${jobId}`);
  }

  updateApplicationStatus(id: number, status: string, recruiterNote?: string): Observable<any> {
    return this.http.patch<any>(`${this.apiUrl}/${id}/status`, { newStatus: status, recruiterNote });
  }
}
