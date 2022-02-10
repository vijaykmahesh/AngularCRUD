import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HighChartsComponent } from './high-charts.component';

describe('HighChartsComponent', () => {
  let component: HighChartsComponent;
  let fixture: ComponentFixture<HighChartsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HighChartsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HighChartsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
