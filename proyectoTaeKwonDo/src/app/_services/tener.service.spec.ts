import { TestBed } from '@angular/core/testing';

import { TenerService } from './tener.service';

describe('TenerService', () => {
  let service: TenerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TenerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
