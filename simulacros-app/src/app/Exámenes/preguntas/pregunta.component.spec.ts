import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreguntaComponent } from './pregunta.component';

describe('ProblemaComponent', () => {
  let component: PreguntaComponent;
  let fixture: ComponentFixture<PreguntaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PreguntaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PreguntaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
