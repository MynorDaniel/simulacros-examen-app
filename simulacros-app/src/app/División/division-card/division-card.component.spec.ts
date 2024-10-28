import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DivisionCardComponent } from './division-card.component';

describe('DivisionCardComponent', () => {
  let component: DivisionCardComponent;
  let fixture: ComponentFixture<DivisionCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DivisionCardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DivisionCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
