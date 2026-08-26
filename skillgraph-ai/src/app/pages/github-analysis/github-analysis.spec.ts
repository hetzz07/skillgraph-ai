import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GithubAnalysis } from './github-analysis';

describe('GithubAnalysis', () => {
  let component: GithubAnalysis;
  let fixture: ComponentFixture<GithubAnalysis>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GithubAnalysis],
    }).compileComponents();

    fixture = TestBed.createComponent(GithubAnalysis);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
