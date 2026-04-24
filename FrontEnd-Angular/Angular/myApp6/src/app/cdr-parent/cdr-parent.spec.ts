import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CdrParent } from './cdr-parent';

describe('CdrParent', () => {
  let component: CdrParent;
  let fixture: ComponentFixture<CdrParent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CdrParent],
    }).compileComponents();

    fixture = TestBed.createComponent(CdrParent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
