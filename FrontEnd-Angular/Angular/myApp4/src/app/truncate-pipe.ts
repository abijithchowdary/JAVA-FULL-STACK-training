import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'truncate',
})
export class TruncatePipe implements PipeTransform {
  transform(str: string, max:number, trail : string = ""): string {
    if(!str) return "";
    if (str.length < max) {
      return str;
    }else{
      return str.substring(0, max) + trail;
    }
  }
}
