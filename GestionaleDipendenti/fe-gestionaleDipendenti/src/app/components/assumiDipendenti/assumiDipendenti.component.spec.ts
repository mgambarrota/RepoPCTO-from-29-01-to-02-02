/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { AssumiDipendentiComponent } from './assumiDipendenti.component';

describe('AssumiDipendentiComponent', () => {
  let component: AssumiDipendentiComponent;
  let fixture: ComponentFixture<AssumiDipendentiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssumiDipendentiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssumiDipendentiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
