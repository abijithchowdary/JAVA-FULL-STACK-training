import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

export interface Job {
  id?: number;
  title: string;
  description: string;
  companyName: string;
  location: string;
  jobType: string;
  experienceYears: number;
  salary?: number;
  postedAt?: string;
}

export interface PagedResponse<T> {
  content: T[];
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
}

@Injectable({
  providedIn: 'root'
})
export class JobService {
  private apiUrl = `${environment.apiUrl}/jobs`;

  constructor(private http: HttpClient) { }

  getAllJobs(page = 0, size = 10): Observable<PagedResponse<Job>> {
    const params = new HttpParams().set('page', page).set('size', size);
    return this.http.get<PagedResponse<Job>>(this.apiUrl, { params });
  }

  getJobById(id: number): Observable<Job> {
    return this.http.get<Job>(`${this.apiUrl}/${id}`);
  }

  searchJobs(filters: any, page = 0, size = 10): Observable<PagedResponse<Job>> {
    let params = new HttpParams().set('page', page).set('size', size);
    if (filters.title) params = params.set('title', filters.title);
    if (filters.location) params = params.set('location', filters.location);
    if (filters.jobType) params = params.set('jobType', filters.jobType);
    if (filters.experienceYears) params = params.set('experienceYears', filters.experienceYears);
    
    return this.http.get<PagedResponse<Job>>(`${this.apiUrl}/search`, { params });
  }

  postJob(job: Job): Observable<Job> {
    return this.http.post<Job>(this.apiUrl, job);
  }

  updateJob(id: number, job: Job): Observable<Job> {
    return this.http.put<Job>(`${this.apiUrl}/${id}`, job);
  }

  deleteJob(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  getMyJobs(page = 0, size = 10): Observable<PagedResponse<Job>> {
    const params = new HttpParams().set('page', page).set('size', size);
    return this.http.get<PagedResponse<Job>>(`${this.apiUrl}/my-jobs`, { params });
  }
}
