import { TestBed } from '@angular/core/testing';

import { PresentarService } from './presentar.service';

describe('PresentarService', () => {
  let service: PresentarService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PresentarService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
