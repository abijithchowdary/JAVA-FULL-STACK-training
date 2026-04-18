import { Component, Input, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-laptop-details',
  imports: [],
  templateUrl: './laptop-details.html',
  styleUrl: './laptop-details.css',
})
export class LaptopDetails {
  @Input() object1! : { id: number; brand: string; model: string; price: number };
  @Output() objchange = new EventEmitter<any>();
  ngOnInit() {
    this.object1 = {...this.object1};
  }
  updateId(newId: number) {
    this.object1.id = newId;
    this.objchange.emit(this.object1.id);
  }
  @Input() laptops : any[] = []; 
}
