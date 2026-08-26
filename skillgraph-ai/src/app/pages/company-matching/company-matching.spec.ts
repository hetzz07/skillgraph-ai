import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyMatching } from './company-matching';

describe('CompanyMatching', () => {
  let component: CompanyMatching;
  let fixture: ComponentFixture<CompanyMatching>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompanyMatching],
    }).compileComponents();

    fixture = TestBed.createComponent(CompanyMatching);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
