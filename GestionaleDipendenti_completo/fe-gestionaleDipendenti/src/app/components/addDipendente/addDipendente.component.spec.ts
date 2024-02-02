/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { AddDipendenteComponent } from './addDipendente.component';

describe('AddDipendenteComponent', () => {
  let component: AddDipendenteComponent;
  let fixture: ComponentFixture<AddDipendenteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddDipendenteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDipendenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
