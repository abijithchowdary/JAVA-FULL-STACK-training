import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Customer } from './components/customer';
import { CustomerDetailsComponent } from './components/customer-component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule, CustomerDetailsComponent],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})

export class App implements OnInit {
  readonly PAGE_SIZE = 5;

  allCustomers: Customer[] = [
    { id: 'C001', name: 'Deepak Sharma',    address: '12 MG Road, Delhi',          email: 'deepak.sharma@email.com',  phone: '+91-9812345670', dateOfBirth: '1990-03-15', gender: 'Male'   },
    { id: 'C002', name: 'Priya Singh',      address: '45 Park Street, Mumbai',     email: 'priya.singh@email.com',    phone: '+91-9823456781', dateOfBirth: '1985-07-22', gender: 'Female' },
    { id: 'C003', name: 'Raj Deepak Kumar', address: '78 Anna Salai, Chennai',     email: 'raj.deepak@email.com',     phone: '+91-9834567892', dateOfBirth: '1993-11-08', gender: 'Male'   },
    { id: 'C004', name: 'Ananya Patel',     address: '34 Brigade Road, Bangalore', email: 'ananya.patel@email.com',   phone: '+91-9845678903', dateOfBirth: '1996-04-30', gender: 'Female' },
    { id: 'C005', name: 'Vikram Nair',      address: '90 Marine Drive, Kochi',     email: 'vikram.nair@email.com',    phone: '+91-9856789014', dateOfBirth: '1988-09-14', gender: 'Male'   },
    { id: 'C006', name: 'Deepdas Reddy',    address: '56 Jubilee Hills, Hyderabad',email: 'deepdas.reddy@email.com',  phone: '+91-9867890125', dateOfBirth: '1991-12-03', gender: 'Male'   },
    { id: 'C007', name: 'Meena Joshi',      address: '23 Lal Bagh, Pune',          email: 'meena.joshi@email.com',    phone: '+91-9878901236', dateOfBirth: '1994-06-17', gender: 'Female' },
    { id: 'C008', name: 'Arjun Mehta',      address: '67 Carter Road, Mumbai',     email: 'arjun.mehta@email.com',    phone: '+91-9889012347', dateOfBirth: '1987-01-25', gender: 'Male'   },
    { id: 'C009', name: 'Sunita Deep',      address: '11 Civil Lines, Jaipur',     email: 'sunita.deep@email.com',    phone: '+91-9890123458', dateOfBirth: '1995-08-09', gender: 'Female' },
    { id: 'C010', name: 'Rahul Gupta',      address: '89 Sector 17, Chandigarh',   email: 'rahul.gupta@email.com',    phone: '+91-9801234569', dateOfBirth: '1992-02-28', gender: 'Male'   },
    { id: 'C011', name: 'Kavita Desai',     address: '44 Warden Road, Mumbai',     email: 'kavita.desai@email.com',   phone: '+91-9712345670', dateOfBirth: '1989-05-11', gender: 'Female' },
    { id: 'C012', name: 'Suresh Iyer',      address: '22 T Nagar, Chennai',        email: 'suresh.iyer@email.com',    phone: '+91-9623456781', dateOfBirth: '1983-10-19', gender: 'Male'   },
    { id: 'C013', name: 'Deep Anand',       address: '36 Koregaon Park, Pune',     email: 'deep.anand@email.com',     phone: '+91-9534567892', dateOfBirth: '1997-03-07', gender: 'Male'  },
    { id: 'C014', name: 'Pooja Verma',      address: '18 Karol Bagh, Delhi',       email: 'pooja.verma@email.com',    phone: '+91-9445678903', dateOfBirth: '1990-07-13', gender: 'Female' },
    { id: 'C015', name: 'Nikhil Tiwari',    address: '55 Hazratganj, Lucknow',     email: 'nikhil.tiwari@email.com',  phone: '+91-9356789014', dateOfBirth: '1986-12-24', gender: 'Male'   },
    { id: 'C016', name: 'Deepika Roy',      address: '13 Salt Lake, Kolkata',      email: 'deepika.roy@email.com',    phone: '+91-9267890125', dateOfBirth: '1993-09-01', gender: 'Female' },
    { id: 'C017', name: 'Amit Saxena',      address: '72 Arera Colony, Bhopal',    email: 'amit.saxena@email.com',    phone: '+91-9178901236', dateOfBirth: '1984-04-18', gender: 'Male'   },
    { id: 'C018', name: 'Ritu Kapoor',      address: '29 Model Town, Ludhiana',    email: 'ritu.kapoor@email.com',    phone: '+91-9089012347', dateOfBirth: '1998-11-29', gender: 'Female' },
  ];

  filteredCustomers: Customer[] = [];
  pagedCustomers: Customer[] = [];
  searchQuery = '';
  currentPage = 0;

  ngOnInit(): void {
    this.applyFilter();
  }

  get totalPages(): number {
    return Math.max(1, Math.ceil(this.filteredCustomers.length / this.PAGE_SIZE));
  }

  get isFirstPage(): boolean {
    return this.currentPage === 0;
  }

  get isLastPage(): boolean {
    return this.currentPage >= this.totalPages - 1;
  }

  onSearch(): void {
    this.currentPage = 0;
    this.applyFilter();
  }

  applyFilter(): void {
    const q = this.searchQuery.trim().toLowerCase();
    this.filteredCustomers = q
      ? this.allCustomers.filter(c => c.name.toLowerCase().includes(q))
      : [...this.allCustomers];
    this.updatePage();
  }

  updatePage(): void {
    const start = this.currentPage * this.PAGE_SIZE;
    this.pagedCustomers = this.filteredCustomers.slice(start, start + this.PAGE_SIZE);
  }

  prevPage(): void {
    if (!this.isFirstPage) {
      this.currentPage--;
      this.updatePage();
    }
  }

  nextPage(): void {
    if (!this.isLastPage) {
      this.currentPage++;
      this.updatePage();
    }
  }
}