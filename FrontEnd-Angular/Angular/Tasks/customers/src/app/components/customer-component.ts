import { Component, Input } from '@angular/core';
import { Customer } from './customer';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer.html',
  styleUrls: ['./customer.css']
})
export class CustomerDetailsComponent {
  @Input() customer!: Customer;

  formatDOB(dob: string): string {
    const date = new Date(dob);
    return date.toLocaleDateString('en-IN', {
      day: 'numeric',
      month: 'short',
      year: 'numeric'
    });
  }
}