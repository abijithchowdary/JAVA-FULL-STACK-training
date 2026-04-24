import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { ApplicationService } from '../../../core/services/application.service';

@Component({
  selector: 'app-job-applicants',
  standalone: true,
  imports: [CommonModule, DatePipe, RouterLink],
  templateUrl: './job-applicants.component.html',
  styleUrls: ['./job-applicants.component.scss']
})
export class JobApplicantsComponent implements OnInit {
  applicants: any[] = [];
  loading = true;
  jobId: number | null = null;
  updatingId: number | null = null;

  constructor(
    private route: ActivatedRoute,
    private applicationService: ApplicationService
  ) {}

  ngOnInit() {
    const idParam = this.route.snapshot.paramMap.get('id');
    if (idParam) {
      this.jobId = Number(idParam);
      this.loadApplicants();
    }
  }

  loadApplicants() {
    if (!this.jobId) return;
    this.applicationService.getApplicantsForJob(this.jobId).subscribe({
      next: (res) => {
        this.applicants = res;
        this.loading = false;
      },
      error: () => {
        this.loading = false;
      }
    });
  }

  updateStatus(appId: number, newStatus: string, recruiterNote?: string) {
    this.updatingId = appId;
    this.applicationService.updateApplicationStatus(appId, newStatus, recruiterNote).subscribe({
      next: () => {
        this.updatingId = null;
        const app = this.applicants.find(a => a.id === appId);
        if (app) app.status = newStatus;
      },
      error: () => {
        this.updatingId = null;
        alert('Failed to update status.');
      }
    });
  }

  getStatusClass(status: string): string {
    switch(status) {
      case 'APPLIED': return 'status-applied';
      case 'UNDER_REVIEW': return 'status-review';
      case 'SHORTLISTED': return 'status-shortlisted';
      case 'REJECTED': return 'status-rejected';
      case 'HIRED': return 'status-hired';
      default: return 'status-applied';
    }
  }
}
