import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../../core/services/auth.service';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment';

@Component({
  selector: 'app-user-profile',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
  profile: any = null;
  loading = true;
  uploadingPic = false;
  uploadingResume = false;
  error = '';
  apiUrl = `${environment.apiUrl}/auth`;

  constructor(private authService: AuthService, private http: HttpClient) {}

  ngOnInit() {
    this.loadProfile();
  }

  loadProfile() {
    this.authService.getProfile().subscribe({
      next: (res) => {
        this.profile = res;
        this.loading = false;
      },
      error: () => {
        this.error = 'Failed to load profile details.';
        this.loading = false;
      }
    });
  }

  onPicSelected(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.uploadingPic = true;
      const formData = new FormData();
      formData.append('picture', file);
      
      this.http.put<{profilePictureUrl: string}>(`${this.apiUrl}/profile/picture`, formData).subscribe({
        next: (res) => {
          this.profile.profilePictureUrl = res.profilePictureUrl;
          this.uploadingPic = false;
        },
        error: () => {
          this.uploadingPic = false;
          alert('Failed to upload picture');
        }
      });
    }
  }

  onResumeSelected(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.uploadingResume = true;
      const formData = new FormData();
      formData.append('resume', file);
      
      this.http.put<{resumeUrl: string}>(`${this.apiUrl}/profile/resume`, formData).subscribe({
        next: (res) => {
          this.profile.resumeUrl = res.resumeUrl;
          this.uploadingResume = false;
        },
        error: () => {
          this.uploadingResume = false;
          alert('Failed to upload resume');
        }
      });
    }
  }
}
