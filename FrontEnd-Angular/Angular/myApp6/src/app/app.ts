import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CdrChild } from './cdr-child/cdr-child';
import { CdrParent } from './cdr-parent/cdr-parent';
import { Rxjsdemo } from './rxjsdemo/rxjsdemo';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CdrParent, CdrChild, Rxjsdemo],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('myapp6');
}