import { TestBed } from '@angular/core/testing';

import { RelacionarService } from './relacionar.service';

describe('RelacionarService', () => {
  let service: RelacionarService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RelacionarService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
