import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CdrChild } from './cdr-child';

describe('CdrChild', () => {
  let component: CdrChild;
  let fixture: ComponentFixture<CdrChild>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CdrChild],
    }).compileComponents();

    fixture = TestBed.createComponent(CdrChild);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
