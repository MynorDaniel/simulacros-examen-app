import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarreraViewComponent } from './carrera-view.component';

describe('CarreraViewComponent', () => {
  let component: CarreraViewComponent;
  let fixture: ComponentFixture<CarreraViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CarreraViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarreraViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
