import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarreraCardComponent } from './carrera-card.component';

describe('CarreraCardComponent', () => {
  let component: CarreraCardComponent;
  let fixture: ComponentFixture<CarreraCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CarreraCardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarreraCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
