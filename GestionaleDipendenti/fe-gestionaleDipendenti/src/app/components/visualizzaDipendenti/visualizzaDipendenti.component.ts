import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { DipendenteFE } from '../../models/dipendente.model';
import { TagModule } from 'primeng/tag';
import { CONST } from '../../shared/constants';
import { DatePipe } from '@angular/common';
import { DipendenteService } from '../../services/dipendente.service';

@Component({
  standalone: true,
  selector: 'app-visualizzaDipendenti',
  templateUrl: './visualizzaDipendenti.component.html',
  styleUrls: ['./visualizzaDipendenti.component.css'],
  imports: [TableModule, ButtonModule, TagModule, DatePipe],
})
export class VisualizzaDipendentiComponent implements OnInit {
  dipendenti: DipendenteFE[];

  constructor(private router: Router, private dipendenteService: DipendenteService) {}

  ngOnInit() {
    this.dipendenteService.getAll().subscribe((dati) => {
      this.dipendenti = dati;
    });
  }

  navigateTo(azione: string) {
    azione == 'assumi'
      ? this.router.navigate(['/assumi'])
      : this.router.navigate(['/']);
  }

  getValue(data: Date): string {
    return data == null ? CONST.ASSUNTO : CONST.LICENZIATO;
  }

  getSeverity(data: Date): string {
    return data == null ? CONST.SUCCESS : CONST.DANGER;
  }

  getIcon(data: Date): string{
    return data != null ? CONST.CHECK : CONST.TIMES;
  }

  getSeverityAzione(data: Date): string{
    return data != null ? CONST.SUCCESS : CONST.DANGER;
  }

  update(dipendente: DipendenteFE){
    dipendente.data_fine_rapporto = dipendente.data_fine_rapporto == null ? new Date() : null;

    this.dipendenteService.save(dipendente).subscribe();
  }

  getall(){
    
  }
}
