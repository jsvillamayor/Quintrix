import { TestBed } from '@angular/core/testing';

import { ConversionCtoFService } from './conversion-cto-f.service';

describe('ConversionCtoFService', () => {
  let service: ConversionCtoFService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConversionCtoFService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
