# Goal Description

Create a modern, responsive Angular frontend for the existing Job Portal Management System backend. The frontend will communicate with the API Gateway running on port 9090 and support features for both Job Seekers and Recruiters.

## User Review Required

> [!IMPORTANT]
> **Design Choice:** I will use Vanilla CSS (SCSS) with a rich, modern aesthetic (gradients, glassmorphism, micro-animations, Inter font) as requested, avoiding Tailwind unless you specify otherwise.
> **Project Location:** The frontend will be generated in `JPMS-Frontend` inside your main workspace folder.

## Open Questions

> [!QUESTION]
> 1. Which version of Angular do you prefer? (e.g., Angular 17 or 18)
> 2. Do you have any specific color themes or styling preferences in mind? (e.g., Dark Mode by default, specific brand colors)
> 3. Should I use Angular Material for UI components (buttons, dialogs, forms), or build purely custom components with SCSS?

## Proposed Changes

### Frontend Initialization

Create a new Angular project using the Angular CLI.

#### [NEW] `JPMS-Frontend/` (Angular Workspace)

### Core Module & Services

We will create core services to handle communication with the API Gateway.

#### [NEW] `src/app/core/services/auth.service.ts`
- `login()`, `register()`, `logout()`, `getProfile()`, token management.

#### [NEW] `src/app/core/services/job.service.ts`
- `getAllJobs()`, `getJobById()`, `searchJobs()`, `postJob()`, `getMyJobs()`, `updateJob()`, `deleteJob()`.

#### [NEW] `src/app/core/services/application.service.ts`
- `applyForJob()`, `getMyApplications()`, `getApplicantsForJob()`, `updateApplicationStatus()`.

#### [NEW] `src/app/core/interceptors/auth.interceptor.ts`
- Attaches the JWT token to outgoing HTTP requests and handles 401 Unauthorized responses.

#### [NEW] `src/app/core/guards/auth.guard.ts`
- Protects routes that require authentication.

#### [NEW] `src/app/core/guards/role.guard.ts`
- Protects routes that require specific roles (e.g., Recruiter-only routes).

### Shared Components

#### [NEW] `src/app/shared/components/navbar/`
- Top navigation bar, dynamic based on authentication state and user role.

#### [NEW] `src/app/shared/components/job-card/`
- Reusable component to display a job summary.

### Feature Modules & Components

#### Auth Feature
- **[NEW] `src/app/features/auth/login/`**: Login form with validation.
- **[NEW] `src/app/features/auth/register/`**: Registration form with role selection.

#### Job Seeker Features
- **[NEW] `src/app/features/jobs/job-list/`**: Public/Seeker view of all jobs with search and filtering.
- **[NEW] `src/app/features/jobs/job-detail/`**: Detailed view of a job with an "Apply" button.
- **[NEW] `src/app/features/applications/my-applications/`**: View applied jobs and their statuses.

#### Recruiter Features
- **[NEW] `src/app/features/recruiter/post-job/`**: Form to post a new job.
- **[NEW] `src/app/features/recruiter/my-jobs/`**: List of jobs posted by the recruiter.
- **[NEW] `src/app/features/recruiter/job-applicants/`**: View applicants for a specific job and update their application status.

#### Profile Feature
- **[NEW] `src/app/features/profile/user-profile/`**: View and edit profile, upload resume/picture.

## Verification Plan

### Automated Tests
- N/A for initial setup.

### Manual Verification
1. Run `ng serve`.
2. Open `http://localhost:4200` in the browser.
3. Test Registration and Login flows.
4. (As Recruiter) Post a job and verify it appears in "My Jobs".
5. (As Job Seeker) Browse jobs, view details, and apply for a job.
6. (As Recruiter) View the application and update its status.
7. Verify all requests are correctly routed through the API Gateway at `http://localhost:9090`.
