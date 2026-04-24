import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output
} from '@angular/core';

@Component({
  selector: 'app-pagination',
  standalone: true,
  templateUrl: './pagination.component.html',
  styleUrl: './pagination.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PaginationComponent implements OnInit, OnChanges {
  @Input({ required: true }) maxPages!: number;
  @Input({ required: true }) itemsPerPage!: number;
  @Input() currentPage = 1;

  /** Optional: how many page buttons to show at once */
  @Input() visiblePages = 10;

  @Output() pageChange = new EventEmitter<number>();

  /** Page numbers currently visible in the UI */
  numbers: number[] = [];
  showLeftEllipsis = false;
  showRightEllipsis = false;

  ngOnInit(): void {
    this.syncNumbers();
  }

  ngOnChanges(): void {
    this.syncNumbers();
  }

  goTo(page: number): void {
    const next = this.clampPage(page);
    if (next === this.currentPage) return;
    this.currentPage = next;
    this.syncNumbers();
    this.pageChange.emit(next);
  }

  previous(): void {
    if (this.currentPage <= 1) return;
    this.goTo(this.currentPage - 1);
  }

  next(): void {
    if (this.currentPage >= this.maxPages) return;
    this.goTo(this.currentPage + 1);
  }

  private clampPage(page: number): number {
    const safeMax = Math.max(1, Number(this.maxPages) || 1);
    const p = Number(page) || 1;
    return Math.min(safeMax, Math.max(1, p));
  }

  private syncNumbers(): void {
    const safeMax = Math.max(1, Number(this.maxPages) || 1);
    this.currentPage = this.clampPage(this.currentPage);

    const limit = Math.max(1, Number(this.visiblePages) || 10);

    // Requirement: "On initialization, generate page numbers from 1 to maxPages"
    // When maxPages exceeds the visible limit, we window the range and add ellipses.
    if (safeMax <= limit) {
      this.numbers = Array.from({ length: safeMax }, (_, i) => i + 1);
      this.showLeftEllipsis = false;
      this.showRightEllipsis = false;
      return;
    }

    const half = Math.floor(limit / 2);
    let start = this.currentPage - half;
    let end = start + limit - 1;

    if (start < 1) {
      start = 1;
      end = start + limit - 1;
    }

    if (end > safeMax) {
      end = safeMax;
      start = end - limit + 1;
    }

    this.numbers = Array.from({ length: end - start + 1 }, (_, i) => start + i);
    this.showLeftEllipsis = start > 1;
    this.showRightEllipsis = end < safeMax;
  }
}

