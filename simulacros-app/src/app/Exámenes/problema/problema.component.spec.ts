import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProblemaComponent } from './problema.component';

describe('ProblemaComponent', () => {
  let component: ProblemaComponent;
  let fixture: ComponentFixture<ProblemaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProblemaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProblemaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
