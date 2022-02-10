import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpeinnerComponent } from './spinner.component';

describe('SpeinnerComponent', () => {
  let component: SpeinnerComponent;
  let fixture: ComponentFixture<SpeinnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpeinnerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpeinnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
