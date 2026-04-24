import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CommonModule, DatePipe } from '@angular/common';
import { JobService, Job } from '../../../core/services/job.service';
import { AuthService } from '../../../core/services/auth.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ApplicationService } from '../../../core/services/application.service';

@Component({
  selector: 'app-job-detail',
  standalone: true,
  imports: [CommonModule, DatePipe, RouterLink, ReactiveFormsModule],
  templateUrl: './job-detail.component.html',
  styleUrls: ['./job-detail.component.scss']
})
export class JobDetailComponent implements OnInit {
  job: Job | null = null;
  loading = true;
  error = '';
  
  isSeeker = false;
  isLoggedIn = false;
  
  showApplyModal = false;
  applyForm: FormGroup;
  applying = false;
  applySuccess = false;
  applyError = '';
  resumeFile: File | null = null;

  constructor(
    private route: ActivatedRoute,
    private jobService: JobService,
    private authService: AuthService,
    private applicationService: ApplicationService,
    private fb: FormBuilder
  ) {
    this.applyForm = this.fb.group({
      coverLetter: [''],
      useExistingResume: [false]
    });
  }

  ngOnInit() {
    this.authService.currentUser$.subscribe(user => {
      this.isLoggedIn = !!user;
      this.isSeeker = user?.role === 'JOB_SEEKER';
    });

    const idParam = this.route.snapshot.paramMap.get('id');
    if (idParam) {
      this.loadJob(Number(idParam));
    }
  }

  loadJob(id: number) {
    this.jobService.getJobById(id).subscribe({
      next: (job) => {
        this.job = job;
        this.loading = false;
      },
      error: () => {
        this.error = 'Failed to load job details. The job might have been removed.';
        this.loading = false;
      }
    });
  }

  openApplyModal() {
    this.showApplyModal = true;
    this.applySuccess = false;
  }

  closeApplyModal() {
    this.showApplyModal = false;
  }

  onFileSelected(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.resumeFile = file;
    }
  }

  submitApplication() {
    if (!this.job) return;

    const useExisting = this.applyForm.get('useExistingResume')?.value;
    if (!useExisting && !this.resumeFile) {
      this.applyError = 'Please upload a resume or select use existing resume.';
      return;
    }

    this.applying = true;
    this.applyError = '';

    this.applicationService.applyForJob(
      this.job.id!,
      this.applyForm.get('coverLetter')?.value,
      useExisting,
      '', // existingResumeUrl if any
      this.resumeFile || undefined
    ).subscribe({
      next: () => {
        this.applying = false;
        this.applySuccess = true;
        setTimeout(() => this.closeApplyModal(), 2000);
      },
      error: (err: any) => {
        this.applying = false;
        this.applyError = err.error?.message || 'Failed to submit application.';
      }
    });
  }
}
