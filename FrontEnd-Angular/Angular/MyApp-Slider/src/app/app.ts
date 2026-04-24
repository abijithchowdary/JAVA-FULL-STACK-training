import { Component, computed, signal } from '@angular/core';
import { PaginationComponent } from './pagination/pagination.component';

@Component({
  selector: 'app-root',
  imports: [PaginationComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('myApp4');

  itemsPerPage = signal(2);
  currentPage = signal(1);

  laptops = [
    { "id": 1, "brand": "Apple", "model": "MacBook Pro", "price": 1999 },
    { "id": 2, "brand": "Dell", "model": "XPS 15", "price": 1799 },
    { "id": 3, "brand": "Lenovo", "model": "ThinkPad X1", "price": 1599 },
    { "id": 1, "brand": "Apple", "model": "MacBook mini", "price": 1999 },
    { "id": 2, "brand": "Dell", "model": "Dell Inspiron", "price": 1799 },
    { "id": 3, "brand": "Lenovo", "model": "Ideapad Gaming", "price": 1599 },
    { "id": 1, "brand": "Apple", "model": "MacBook Pro", "price": 1999 },
    { "id": 2, "brand": "Dell", "model": "XPS 15", "price": 1799 },
    { "id": 3, "brand": "Lenovo", "model": "ThinkPad X1", "price": 1599 }
  ];

  maxPages = computed(() => {
    const perPage = Math.max(1, Number(this.itemsPerPage()) || 1);
    return Math.max(1, Math.ceil(this.laptops.length / perPage));
  });

  displayedLaptops = computed(() => {
    const perPage = Math.max(1, Number(this.itemsPerPage()) || 1);
    const page = Math.min(this.maxPages(), Math.max(1, Number(this.currentPage()) || 1));
    const start = (page - 1) * perPage;
    return this.laptops.slice(start, start + perPage);
  });

  onPageChange(page: number): void {
    const safePage = Math.min(this.maxPages(), Math.max(1, Number(page) || 1));
    this.currentPage.set(safePage);
  }
}