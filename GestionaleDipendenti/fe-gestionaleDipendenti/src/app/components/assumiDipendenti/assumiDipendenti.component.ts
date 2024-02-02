import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SelectItem } from 'primeng/api';
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { CalendarModule } from 'primeng/calendar';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button';
import { DipendenteService } from '../../services/dipendente.service';
import { DipendenteFE } from '../../models/dipendente.model';

@Component({
  standalone: true,
  selector: 'app-assumiDipendenti',
  templateUrl: './assumiDipendenti.component.html',
  styleUrls: ['./assumiDipendenti.component.css'],
  imports: [
    CardModule, 
    ReactiveFormsModule,
    InputTextModule,
    CommonModule,
    CalendarModule,
    DropdownModule,
    ButtonModule
  ]
})
export class AssumiDipendentiComponent implements OnInit {

  dipendenteForm = this.fb.group({
    nome: ['', Validators.required],
    cognome: ['', Validators.required],
    data_nascita: ['', Validators.required],
    data_assunzione: ['', Validators.required],
    sede_appartenenza: ['', Validators.required]
  })

  now: Date = new Date();
  sedi: SelectItem[];

  constructor(private router: Router, private fb: FormBuilder, private dipendenteService: DipendenteService) { 

  }

  ngOnInit() {
    this.sedi = [
      {label: 'Roma', value: 'Roma'},
      {label: 'Bari', value: 'Bari'},
      {label: 'Milano', value: 'Milano'},
      {label: 'Padova', value: 'Padova'},
      {label: 'Torino', value: 'Torino'},
      {label: 'Treviso', value: 'Treviso'}
    ]
  }

  navigateTo(azione: string) {
    azione == 'visuallizza'
      ? this.router.navigate(['/visualizza'])
      : this.router.navigate(['/']);
  }

  addUser(){
    this.dipendenteService
    .save(new DipendenteFE().formToModel(this.dipendenteForm))
    .subscribe();
  }

}
