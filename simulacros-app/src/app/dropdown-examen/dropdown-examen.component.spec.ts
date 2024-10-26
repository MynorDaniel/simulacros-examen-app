import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DropdownExamenComponent } from './dropdown-examen.component';

describe('DropdownExamenComponent', () => {
  let component: DropdownExamenComponent;
  let fixture: ComponentFixture<DropdownExamenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DropdownExamenComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DropdownExamenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
