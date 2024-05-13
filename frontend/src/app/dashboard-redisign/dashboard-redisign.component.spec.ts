import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardRedisignComponent } from './dashboard-redisign.component';

describe('DashboardRedisignComponent', () => {
  let component: DashboardRedisignComponent;
  let fixture: ComponentFixture<DashboardRedisignComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardRedisignComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DashboardRedisignComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
