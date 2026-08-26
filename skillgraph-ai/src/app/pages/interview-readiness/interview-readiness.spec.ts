import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterviewReadiness } from './interview-readiness';

describe('InterviewReadiness', () => {
  let component: InterviewReadiness;
  let fixture: ComponentFixture<InterviewReadiness>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InterviewReadiness],
    }).compileComponents();

    fixture = TestBed.createComponent(InterviewReadiness);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
