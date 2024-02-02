import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { SelectItem } from 'primeng/api';
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { CalendarModule } from 'primeng/calendar';
import { DropdownModule } from 'primeng/dropdown';
import { Router } from '@angular/router';
import { DipendenteService } from '../../services/dipendente.service';
import { DipendenteFE } from '../../models/dipendente.model';

@Component({
  standalone: true,
  selector: 'app-addDipendente',
  templateUrl: './addDipendente.component.html',
  styleUrls: ['./addDipendente.component.css'],
  imports: [
    CardModule,
    ReactiveFormsModule,
    InputTextModule,
    CommonModule,
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
    private router: Router,
    private dipendenteService: DipendenteService
  ) {}

  ngOnInit() {
    this.sedi = [
      { label: 'Bari', value: 'Bari' },
      { label: 'Milano', value: 'Milano' },
      { label: 'Padova', value: 'Padova' },
      { label: 'Torino', value: 'Torino' },
      { label: 'Treviso', value: 'Treviso' },
      { label: 'Roma', value: 'Roma' },
    ];
  }

  navigateTo(azione: string) {
    if (azione == 'visualizza') this.router.navigate(['/visualizza']);
    else this.router.navigate(['']);
  }

  addUser() {
    this.dipendenteService
      .save(new DipendenteFE().formToModel(this.dipendenteForm.value))
      .subscribe();
  }
}
