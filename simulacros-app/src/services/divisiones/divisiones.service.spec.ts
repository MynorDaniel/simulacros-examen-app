import { TestBed } from '@angular/core/testing';

import { DivisionesService } from './divisiones.service';

describe('DivisionesService', () => {
  let service: DivisionesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DivisionesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
