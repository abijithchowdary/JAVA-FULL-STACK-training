import { Injectable } from '@angular/core';

export interface Training {
  title: string;
  topic: string;
  maxTrainees: number;
  startDate: string; // yyyy-mm-dd (from <input type="date">)
  endDate: string; // yyyy-mm-dd
  trainerName: string;
  venue: string;
}

@Injectable({
  providedIn: 'root',
})
export class TrainingService {
  private readonly storageKey = 'training-portal.trainings';

  private trainings: Training[] = this.loadInitialTrainings();

  private parseLocalDate(dateString: string): Date | null {
    // Expecting yyyy-mm-dd (from <input type="date">). Parse as *local* midnight.
    const match = /^(\d{4})-(\d{2})-(\d{2})$/.exec(dateString);
    if (!match) return null;
    const year = Number(match[1]);
    const monthIndex = Number(match[2]) - 1;
    const day = Number(match[3]);
    const d = new Date(year, monthIndex, day);
    return Number.isNaN(d.getTime()) ? null : d;
  }

  private loadInitialTrainings(): Training[] {
    try {
      const raw = localStorage.getItem(this.storageKey);
      if (!raw) return [];
      const parsed = JSON.parse(raw) as unknown;
      if (!Array.isArray(parsed)) return [];
      return parsed as Training[];
    } catch {
      return [];
    }
  }

  private persist() {
    try {
      localStorage.setItem(this.storageKey, JSON.stringify(this.trainings));
    } catch {
      // ignore storage failures (e.g., private mode/quota)
    }
  }

  getTrainings(): Training[] {
    return [...this.trainings];
  }

  getUpcomingTrainings(today = new Date()): Training[] {
    const startOfToday = new Date(
      today.getFullYear(),
      today.getMonth(),
      today.getDate()
    );

    return this.trainings
      .filter((t) => {
        const start = this.parseLocalDate(t.startDate);
        return !!start && start >= startOfToday;
      })
      .slice()
      .sort(
        (a, b) =>
          (this.parseLocalDate(a.startDate)?.getTime() ?? 0) -
          (this.parseLocalDate(b.startDate)?.getTime() ?? 0)
      );
  }

  addTraining(training: Training) {
    this.trainings = [...this.trainings, training];
    this.persist();
  }
}
