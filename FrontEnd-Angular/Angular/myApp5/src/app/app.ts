import { Component, ElementRef, signal, ViewChild } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TruncatePipe } from './truncate-pipe';
import { Highlight } from "./highlight";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, TruncatePipe, Highlight],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('myApp5');
  longText : string = "This is a really really long text we are using here , ig its more then 20 is it ? hell yah";

  show = false;
  toggle(){
    if(this.show){
      this.show = false;
    }
    else{
      this.show = true;
    }
  }
  @ViewChild('v') v : any;
  // @ViewChild(userDetails) user0!: ElementRef;
  // @ViewChild('user0') list!: QueryList<UserDetails>;
  ngAfterViewInit(){
    console.log("is it view ",this.v);
  }
}
