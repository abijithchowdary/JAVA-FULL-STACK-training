import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Training, TrainingService } from '../training.service';

@Component({
  selector: 'app-training-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './training-list.html',
  styleUrl: './training-list.css'
})
export class TrainingListComponent implements OnInit {

  trainings: Training[] = [];

  constructor(private trainingService: TrainingService) {}

  ngOnInit() {
    this.trainings = this.trainingService.getUpcomingTrainings();
  }
}