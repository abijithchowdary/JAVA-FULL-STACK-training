import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Training, TrainingService } from '../training.service';

@Component({
  selector: 'app-add-training',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-training.html',
  styleUrl: './add-training.css',
})
export class AddTrainingComponent {
  model: Training = {
    title: '',
    topic: '',
    maxTrainees: 1,
    startDate: '',
    endDate: '',
    trainerName: '',
    venue: '',
  };

  constructor(
    private trainingService: TrainingService,
    private router: Router
  ) {}

  addTraining(form: NgForm) {
    if (form.invalid) return;

    this.trainingService.addTraining({ ...this.model });
    form.resetForm({
      title: '',
      topic: '',
      maxTrainees: 1,
      startDate: '',
      endDate: '',
      trainerName: '',
      venue: '',
    });
    this.router.navigateByUrl('/trainings');
  }
}
