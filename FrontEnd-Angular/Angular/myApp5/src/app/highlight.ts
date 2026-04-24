import { Directive, ElementRef, Input, HostListener } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
})
export class Highlight {
  constructor(private element:ElementRef) {

  }

  //events  -  native events
  @Input('appHighlight') color = `pink`;
  @HostListener('mouseenter')
  onMouseEnter(){
    this.element.nativeElement.style.backgroundColor = this.color;
  }
  @HostListener('mouseleave')
  onMouseLeave(){
    this.element.nativeElement.style.backgroundColor = 'orange';
  }
}
