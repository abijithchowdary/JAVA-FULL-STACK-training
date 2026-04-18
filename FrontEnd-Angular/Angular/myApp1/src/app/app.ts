import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NgFor } from '@angular/common';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet,NgFor],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'myApp1';
  name = signal('avni');

  user={
    name:'avni garg',
    address:'haryana',
    age:22,
    phones:[5645366224,4567856748],
    gender:'male'
  };
  users=[
    {name:'avi',address:'haryana',age:22,gender:'female',edit : false},
    {name:'shubhi',address:'delhi',age:23,gender:'male',edit : true},
    {name:'palak',address:'chd',age:24,gender:'female',edit : false}
  ]
}

