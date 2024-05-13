import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LandingRedesignComponent } from './landing-redesign.component';

describe('LandingRedesignComponent', () => {
  let component: LandingRedesignComponent;
  let fixture: ComponentFixture<LandingRedesignComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LandingRedesignComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LandingRedesignComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
