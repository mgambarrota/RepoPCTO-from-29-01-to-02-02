import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DipendenteBE, DipendenteFE } from '../models/dipendente.model';
import { CONST } from '../shared/constants';
import { map, tap } from 'rxjs';
import { GenericApiService } from './generic-api.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class DipendenteService {
  dipendenti: DipendenteFE[];

  constructor(
    private genericService: GenericApiService,
    private router: Router
  ) {}

  getAll() {
    return this.genericService
      .getGenericService<DipendenteBE[]>(CONST.API_URL + '/getAll')
      .pipe(
        map((res) => {
          this.dipendenti =
            res.payload?.map((dip) => new DipendenteFE(dip)) || [];
          return this.dipendenti;
        })
      );
  }

  save(dipendente: DipendenteFE) {
    let dipendenteBE: DipendenteBE = dipendente.toBE();
    return this.genericService
      .postGenericService<DipendenteBE, boolean>(
        dipendenteBE,
        CONST.API_URL + '/insert'
      )
      .pipe(
        map((res) => {
          if (res.payload) {
            this.router.navigate([
              '/viewAll',
            ]);
          }
        })
      );
  }
}
