import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LearningRoadmap } from './learning-roadmap';

describe('LearningRoadmap', () => {
  let component: LearningRoadmap;
  let fixture: ComponentFixture<LearningRoadmap>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LearningRoadmap],
    }).compileComponents();

    fixture = TestBed.createComponent(LearningRoadmap);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
