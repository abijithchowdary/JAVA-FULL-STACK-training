import { ChangeDetectionStrategy, Component, Input } from '@angular/core';

@Component({
  selector: 'app-cdr-child',
  imports: [],
  templateUrl: './cdr-child.html',
  styleUrl: './cdr-child.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CdrChild {
  @Input() user = {
    username: 'defaultChildName',
    role: 'defaultChildRole'
  };
}