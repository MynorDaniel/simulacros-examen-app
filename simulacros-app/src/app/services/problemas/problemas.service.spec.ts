import { TestBed } from '@angular/core/testing';

import { ProblemasService } from './problemas.service';

describe('ProblemasService', () => {
  let service: ProblemasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProblemasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
