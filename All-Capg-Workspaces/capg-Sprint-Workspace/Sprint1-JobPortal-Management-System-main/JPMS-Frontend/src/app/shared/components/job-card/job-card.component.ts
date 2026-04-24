import { Component, Input } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Job } from '../../../core/services/job.service';

@Component({
  selector: 'app-job-card',
  standalone: true,
  imports: [CommonModule, RouterLink, DatePipe],
  templateUrl: './job-card.component.html',
  styleUrls: ['./job-card.component.scss']
})
export class JobCardComponent {
  @Input() job!: Job;
  @Input() showApplyButton: boolean = true;
  @Input() showEditButton: boolean = false;
  @Input() customActionLink?: string;
  @Input() customActionText?: string;
}
