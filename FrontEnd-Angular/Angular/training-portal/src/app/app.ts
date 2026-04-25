import { CommonModule } from '@angular/common';
import { Component, signal } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { RoleService, UserRole } from './role.service';

@Component({
  selector: 'app-root',
  imports: [CommonModule, RouterOutlet, RouterLink],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('training-portal');

  constructor(public roleService: RoleService) {}

  setRole(role: string) {
    this.roleService.setRole(role as UserRole);
  }
}
