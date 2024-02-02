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
  standalone:true,
  selector: 'app-visualizzaDipendenti',
  templateUrl: './visualizzaDipendenti.component.html',
  styleUrls: ['./visualizzaDipendenti.component.css'],
   imports:[
    TableModule,
    ButtonModule,
    TagModule,
    DatePipe
   ]
})
export class VisualizzaDipendentiComponent implements OnInit {

  dipendenti: DipendenteFE[];
  constructor(private router: Router, private dipendenteService: DipendenteService) { }

  ngOnInit() {
    this.dipendenteService.getAll().subscribe((dati) => {
      this.dipendenti = dati;
    })
  }

  navigateTo(azione: string) {
    if(azione == 'assumi')this.router.navigate(['/assumi']);
    else this.router.navigate(['']);
  }


  getValue(data: Date): string{
    if(data == null) return CONST.ASSUNTO;
    else return CONST.LICENZIATO;
  }

  getSeverity(data: Date):string {
    if(data == null) return CONST.SUCCESS;
    else return CONST.DANGER;
  }

  getIcon(data: Date): string{
    if(data != null) return CONST.CHECK;
    else return CONST.TIMES;
  }

  getSeverityAzione(data: Date): string{
    if(data != null) return CONST.SUCCESS;
    else return CONST.DANGER;
  }


  update(dipendente: DipendenteFE){
    if(dipendente.data_fine_rapporto == null){
      dipendente.data_fine_rapporto = new Date();
    }else{
      dipendente.data_fine_rapporto = null;
    }

    this.dipendenteService.save(dipendente).subscribe();
  }
}
