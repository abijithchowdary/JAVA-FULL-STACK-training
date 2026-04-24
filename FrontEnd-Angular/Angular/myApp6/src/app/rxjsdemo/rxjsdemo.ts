import { Component, ElementRef, ViewChild } from '@angular/core';
import { filter, from, of, fromEvent, debounceTime, map } from 'rxjs';
import { CdrParent } from "../cdr-parent/cdr-parent";
@Component({
  selector: 'app-rxjsdemo',
  imports: [CdrParent],
  templateUrl: './rxjsdemo.html',
  styleUrl: './rxjsdemo.css',
})
export class Rxjsdemo {
    @ViewChild('rxInput') inputEl! : ElementRef;
    ngOnInit(){
    var obs = of(1,2,3);
    obs.subscribe(data => console.log(data));

    var obs2 = from(['apple','banana','orange','chicku','grapes']);
    obs2.pipe(filter(f=>f.includes('a'))).subscribe(item=>
      console.log("Filtered item "+item)
    );
  }
  ngAfterViewInit(){
    fromEvent(this.inputEl.nativeElement,'input')
    .pipe(debounceTime(500 * 4))
    .pipe(map(e=>this.inputEl.nativeElement.value))
    .subscribe(event=>console.log(event));
  }
  
}