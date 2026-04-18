import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserDetails } from './components/user-details/user-details';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet,UserDetails],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App {
  protected readonly title = signal('myApp2');
  name = "Abhijit";
  age = 22;
  


  changeName(){
    this.name = "Abhijit Billa";
  }

  users=[
    {name:'avi',address:'haryana',age:22,gender:'female',edit : false},
    {name:'shubhi',address:'delhi',age:23,gender:'male',edit : true},
    {name:'palak',address:'chd',age:24,gender:'female',edit : false}
  ]

}
