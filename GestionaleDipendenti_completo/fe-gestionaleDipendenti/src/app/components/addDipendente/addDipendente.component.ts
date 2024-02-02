import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { CardModule } from 'primeng/card';
import { ReactiveFormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { CalendarModule } from 'primeng/calendar';
import { SelectItem } from 'primeng/api';
import { DropdownModule } from 'primeng/dropdown';
import { DipendenteService } from '../../services/dipendente.service';
import { DipendenteFE } from '../../models/dipendente.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addDipendente',
  templateUrl: './addDipendente.component.html',
  styleUrls: ['./addDipendente.component.css'],
  standalone: true,
  imports: [
    CommonModule,
    CardModule,
    ReactiveFormsModule,
    InputTextModule,
    ButtonModule,
    CalendarModule,
    DropdownModule,
  ],
})
export class AddDipendenteComponent implements OnInit {
  dipendenteForm = this.fb.group({
    nome: ['', Validators.required],
    cognome: ['', Validators.required],
    data_nascita: ['', Validators.required],
    data_assunzione: ['', Validators.required],
    sede_appartenenza: ['', Validators.required],
  });

  now: Date = new Date();
  sedi: SelectItem[];

  constructor(
    private fb: FormBuilder,
    private dipendenteService: DipendenteService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.sedi = [
      { label: 'Bari - Italia', value: 'Bari - Italia' },
      { label: 'Milano - Italia', value: 'Milano - Italia' },
      { label: 'Torino - Italia', value: 'Torino - Italia' },
      { label: 'Padova - Italia', value: 'Padova - Italia' },
      { label: 'Treviso - Italia', value: 'Treviso - Italia' },
      { label: 'Roma - Italia', value: 'Roma - Italia' },
      { label: 'Köln - Germania', value: 'Köln - Germania' },
      { label: 'Balerna - Svizzera', value: 'Balerna - Svizzera' },
    ];
  }

  addUser() {
    this.dipendenteService
      .save(new DipendenteFE().formToModel(this.dipendenteForm.value))
      .subscribe();
  }
  navigateTo(route: string): void {
    if (route === 'visualizza') {
      this.router.navigate(['/viewAll']);
    } else if (route === 'home') {
      this.router.navigate(['/']);
    }
  }
}
