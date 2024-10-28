import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CursoViewComponent } from './curso-view.component';

describe('CursoViewComponent', () => {
  let component: CursoViewComponent;
  let fixture: ComponentFixture<CursoViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CursoViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CursoViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
