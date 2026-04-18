import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LaptopDetails } from './laptop-details';

describe('LaptopDetails', () => {
  let component: LaptopDetails;
  let fixture: ComponentFixture<LaptopDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LaptopDetails],
    }).compileComponents();

    fixture = TestBed.createComponent(LaptopDetails);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
