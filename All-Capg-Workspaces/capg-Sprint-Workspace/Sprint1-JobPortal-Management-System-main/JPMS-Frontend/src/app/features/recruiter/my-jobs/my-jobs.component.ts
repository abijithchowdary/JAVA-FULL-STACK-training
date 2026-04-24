import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JobService, Job } from '../../../core/services/job.service';
import { JobCardComponent } from '../../../shared/components/job-card/job-card.component';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-my-jobs',
  standalone: true,
  imports: [CommonModule, JobCardComponent, RouterLink],
  templateUrl: './my-jobs.component.html',
  styleUrls: ['./my-jobs.component.scss']
})
export class MyJobsComponent implements OnInit {
  jobs: Job[] = [];
  loading = true;
  
  currentPage = 0;
  totalPages = 0;

  constructor(private jobService: JobService) {}

  ngOnInit() {
    this.loadMyJobs();
  }

  loadMyJobs() {
    this.loading = true;
    this.jobService.getMyJobs(this.currentPage).subscribe({
      next: (res) => {
        this.jobs = res.content;
        this.totalPages = res.totalPages;
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
      this.loadMyJobs();
    }
  }

  prevPage() {
    if (this.currentPage > 0) {
      this.currentPage--;
      this.loadMyJobs();
    }
  }
}
