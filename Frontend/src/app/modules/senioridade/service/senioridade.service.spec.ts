import { TestBed } from '@angular/core/testing';

import { SenioridadeService } from './senioridade.service';

describe('SenioridadeService', () => {
  let service: SenioridadeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SenioridadeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
