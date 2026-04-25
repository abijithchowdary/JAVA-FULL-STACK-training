import { Injectable, signal } from '@angular/core';

export type UserRole = 'manager' | 'trainee';

@Injectable({ providedIn: 'root' })
export class RoleService {
  private readonly _role = signal<UserRole>('trainee');

  role = this._role.asReadonly();

  setRole(role: UserRole) {
    this._role.set(role);
  }

  isManager(): boolean {
    return this._role() === 'manager';
  }
}

