import { ChangeDetectionStrategy, Component } from '@angular/core';
import { CdrChild } from "../cdr-child/cdr-child";

@Component({
  selector: 'app-cdr-parent',
  imports: [CdrChild],
  templateUrl: './cdr-parent.html',
  styleUrl: './cdr-parent.css',
})
export class CdrParent {
  user = {
    username: 'admin',
    role: 'Administrator'
  };
  changeName(){
    // this.user.username = "Child admin 💀";
    this.user = {...this.user,username:"Mukesh"}
  }
}