import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewDirectiveComponent } from './new-directive.component';

describe('NewDirectiveComponent', () => {
  let component: NewDirectiveComponent;
  let fixture: ComponentFixture<NewDirectiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewDirectiveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewDirectiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
