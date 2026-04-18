import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-user-details',
  imports: [],
  templateUrl: './user-details.html',
  styleUrl: './user-details.css',
})
export class UserDetails {
  @Input() name = 'default';
  @Input() age = 22;
  @Input() address = 'india';
  @Input() gender = 'male';
}
