import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SkillGraph } from './skill-graph';

describe('SkillGraph', () => {
  let component: SkillGraph;
  let fixture: ComponentFixture<SkillGraph>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SkillGraph],
    }).compileComponents();

    fixture = TestBed.createComponent(SkillGraph);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
