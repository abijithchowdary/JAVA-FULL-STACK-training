import { Routes } from '@angular/router';
import { LoginComponent } from './features/auth/login/login.component';
import { RegisterComponent } from './features/auth/register/register.component';
import { JobListComponent } from './features/jobs/job-list/job-list.component';
import { JobDetailComponent } from './features/jobs/job-detail/job-detail.component';
import { UserProfileComponent } from './features/profile/user-profile/user-profile.component';
import { MyApplicationsComponent } from './features/applications/my-applications/my-applications.component';
import { PostJobComponent } from './features/recruiter/post-job/post-job.component';
import { MyJobsComponent } from './features/recruiter/my-jobs/my-jobs.component';
import { JobApplicantsComponent } from './features/recruiter/job-applicants/job-applicants.component';
import { authGuard } from './core/guards/auth.guard';
import { roleGuard } from './core/guards/role.guard';

export const routes: Routes = [
  { path: '', redirectTo: '/jobs', pathMatch: 'full' },
  { path: 'auth/login', component: LoginComponent },
  { path: 'auth/register', component: RegisterComponent },
  
  { path: 'jobs', component: JobListComponent },
  { path: 'jobs/:id', component: JobDetailComponent },
  
  { 
    path: 'profile', 
    component: UserProfileComponent,
    canActivate: [authGuard]
  },
  
  { 
    path: 'applications/my-applications', 
    component: MyApplicationsComponent,
    canActivate: [authGuard, roleGuard],
    data: { expectedRole: 'JOB_SEEKER' }
  },
  
  { 
    path: 'recruiter/post-job', 
    component: PostJobComponent,
    canActivate: [authGuard, roleGuard],
    data: { expectedRole: 'RECRUITER' }
  },
  { 
    path: 'recruiter/my-jobs', 
    component: MyJobsComponent,
    canActivate: [authGuard, roleGuard],
    data: { expectedRole: 'RECRUITER' }
  },
  { 
    path: 'recruiter/job-applicants/:id', 
    component: JobApplicantsComponent,
    canActivate: [authGuard, roleGuard],
    data: { expectedRole: 'RECRUITER' }
  },
  
  { path: '**', redirectTo: '/jobs' }
];
