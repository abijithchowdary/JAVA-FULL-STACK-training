import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'truncate',
})
export class TruncatePipe implements PipeTransform {
  transform(str: String, max : number, trail : string = ""): String {
    if(str == null){
      return "";
    }
    else if(str.length < max){
      return str;
    }
    else{
      return str.substring(0,max) + trail;
    }
  }
}
