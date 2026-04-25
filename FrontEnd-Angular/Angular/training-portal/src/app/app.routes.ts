import { Routes } from '@angular/router';
import { AddTrainingComponent } from './add-training/add-training';
import { TrainingListComponent } from './training-list/training-list';
import { managerGuard } from './manager.guard';

export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'trainings' },
  { path: 'trainings', component: TrainingListComponent },
  {
    path: 'add-training',
    component: AddTrainingComponent,
    canActivate: [managerGuard],
  },
  { path: '**', redirectTo: 'trainings' },
];
