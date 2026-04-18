import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LaptopDetails } from "./components/laptop-details/laptop-details";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, LaptopDetails],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('myapp3');

  laptops= [
    { "id": 1, "brand": "Apple", "model": "MacBook Pro", "price": 120000 },
    { "id": 2, "brand": "Dell", "model": "XPS 15", "price": 80000 },
    { "id": 3, "brand": "Lenovo", "model": "ThinkPad X1", "price": 70000 }
  ]

  obj1 : { id: number; brand: string; model: string; price: number } = { id: 1111, brand: 'red magic', model: '11 pro', price: 89000 };

  handleUpdate(newId: any) {
    this.obj1.id = newId;
  }
}

