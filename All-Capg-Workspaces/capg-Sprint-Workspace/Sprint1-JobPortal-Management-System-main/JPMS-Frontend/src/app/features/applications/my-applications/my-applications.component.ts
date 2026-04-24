import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { ApplicationService } from '../../../core/services/application.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-my-applications',
  standalone: true,
  imports: [CommonModule, DatePipe, RouterLink],
  templateUrl: './my-applications.component.html',
  styleUrls: ['./my-applications.component.scss']
})
export class MyApplicationsComponent implements OnInit {
  applications: any[] = [];
  loading = true;

  constructor(private applicationService: ApplicationService) {}

  ngOnInit() {
    this.loadApplications();
  }

  loadApplications() {
    this.applicationService.getMyApplications().subscribe({
      next: (res) => {
        this.applications = res;
        this.loading = false;
      },
      error: () => {
        this.loading = false;
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
