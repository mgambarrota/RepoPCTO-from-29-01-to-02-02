import { Injectable } from '@angular/core';
import { GenericApiService } from './generic-api.service';
import { Router } from '@angular/router';
import { DipendenteBE, DipendenteFE } from '../models/dipendente.model';
import { CONST } from '../shared/constants';
import { map } from 'rxjs';

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
    return this.genericService.getGenericService<DipendenteBE[]>(
      CONST.API_URL + '/getAll'
    ).pipe(
      map((result) => {
        this.dipendenti = result?.payload?.map(
          (dip) => new DipendenteFE(dip)
        ) || []
        return this.dipendenti;
      })
    )
  }


  save(dipendente:DipendenteFE){
    let dipendenteBE: DipendenteBE = dipendente.toBE();

    return this.genericService.postGenericService<DipendenteBE>(
      dipendenteBE, CONST.API_URL + '/insert'
    ).pipe(
      map((result) => {
        if(result.payload){
          this.router.navigate(['/visualizza']);
        }
      })
    )

  }
}
