import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { JobService, Job } from '../../../core/services/job.service';
import { JobCardComponent } from '../../../shared/components/job-card/job-card.component';
import { debounceTime, distinctUntilChanged } from 'rxjs';

@Component({
  selector: 'app-job-list',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, JobCardComponent],
  templateUrl: './job-list.component.html',
  styleUrls: ['./job-list.component.scss']
})
export class JobListComponent implements OnInit {
  jobs: Job[] = [];
  searchForm: FormGroup;
  loading = true;

  // Pagination
  currentPage = 0;
  totalPages = 0;
  totalElements = 0;

  constructor(private jobService: JobService, private fb: FormBuilder) {
    this.searchForm = this.fb.group({
      title: [''],
      location: [''],
      jobType: [''],
      experienceYears: ['']
    });
  }

  ngOnInit() {
    this.loadJobs();

    this.searchForm.valueChanges.pipe(
      debounceTime(500),
      distinctUntilChanged()
    ).subscribe(() => {
      this.currentPage = 0;
      this.loadJobs();
    });
  }

  loadJobs() {
    this.loading = true;
    const filters = this.searchForm.value;
    
    // Clean empty filters
    const cleanFilters: any = {};
    if (filters.title) cleanFilters.title = filters.title;
    if (filters.location) cleanFilters.location = filters.location;
    if (filters.jobType) cleanFilters.jobType = filters.jobType;
    if (filters.experienceYears) cleanFilters.experienceYears = filters.experienceYears;

    const hasFilters = Object.keys(cleanFilters).length > 0;

    const request = hasFilters 
      ? this.jobService.searchJobs(cleanFilters, this.currentPage)
      : this.jobService.getAllJobs(this.currentPage);

    request.subscribe({
      next: (response) => {
        this.jobs = response.content;
        this.totalPages = response.totalPages;
        this.totalElements = response.totalElements;
        this.loading = false;
      },
      error: () => {
        this.loading = false;
      }
    });
  }

  nextPage() {
    if (this.currentPage < this.totalPages - 1) {
      this.currentPage++;
      this.loadJobs();
    }
  }

  prevPage() {
    if (this.currentPage > 0) {
      this.currentPage--;
      this.loadJobs();
    }
  }
}
