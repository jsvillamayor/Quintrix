import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThirdDirectiveComponent } from './third-directive.component';

describe('ThirdDirectiveComponent', () => {
  let component: ThirdDirectiveComponent;
  let fixture: ComponentFixture<ThirdDirectiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ThirdDirectiveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ThirdDirectiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
