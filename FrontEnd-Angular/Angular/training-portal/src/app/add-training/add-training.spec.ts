import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTrainingComponent } from './add-training';

describe('AddTrainingComponent', () => {
  let component: AddTrainingComponent;
  let fixture: ComponentFixture<AddTrainingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddTrainingComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(AddTrainingComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
