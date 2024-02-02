import { Component, OnInit } from '@angular/core';
import { DipendenteService } from '../../services/dipendente.service';
import { DipendenteFE } from '../../models/dipendente.model';
import { TableModule } from 'primeng/table';
import { SelectButtonModule } from 'primeng/selectbutton';
import { FormsModule } from '@angular/forms';
import { CommonModule, DatePipe } from '@angular/common';
import { TagModule } from 'primeng/tag';
import { CONST } from '../../shared/constants';
import { Router } from '@angular/router';
import { ButtonModule } from 'primeng/button';

@Component({
  standalone: true,
  selector: 'app-viewDipendenti',
  templateUrl: './viewDipendenti.component.html',
  imports: [
    TableModule,
    SelectButtonModule,
    FormsModule,
    DatePipe,
    CommonModule,
    TagModule,
    ButtonModule
  ],
  styleUrls: ['./viewDipendenti.component.css'],
})
export class ViewDipendentiComponent implements OnInit {
  dipendenti: DipendenteFE[];
  selectedSize: any = '';
  sizes!: any[];

  constructor(
    private dipendenteService: DipendenteService,
    private router: Router
  ) {}

  ngOnInit() {
    this.sizes = [
      { name: 'Small', class: 'p-datatable-sm' },
      { name: 'Normal', class: '' },
      { name: 'Large', class: 'p-datatable-lg' },
    ];
    this.dipendenteService.getAll().subscribe(
      (data) => (this.dipendenti = data),
      (err) => {
        console.error(err);
      }
    );
  }

  getValue(data_fine_rapporto: Date): string {
    if (data_fine_rapporto != null) return CONST.LICENZIATO;
    else return CONST.ASSUNTO;
  }

  getSeverity(data_fine_rapporto: Date): string {
    if (data_fine_rapporto != null) return CONST.DANGER;
    else return CONST.SUCCESS;
  }

  getSeverityAzioni(data_fine_rapporto: Date): string {
    if (data_fine_rapporto == null) return CONST.DANGER;
    else return CONST.SUCCESS;
  }

  getIcon(data_fine_rapporto: Date):string{
    if(data_fine_rapporto == null) return CONST.TIMES;
    else return CONST.CHECK;
  }
  
  update(dipendente: DipendenteFE){
    if(dipendente?.data_fine_rapporto == null){
      dipendente.data_fine_rapporto = new Date();
    }else{
      dipendente.data_fine_rapporto = null;
    }

    this.dipendenteService
      .save(dipendente)
      .subscribe();
  }

  navigateTo(route: string): void {
    if (route === 'assumi') {
      this.router.navigate(['/addDip']);
    } else if (route === 'home') {
      this.router.navigate(['/']);
    }
  }
}
