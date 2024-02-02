import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ConsoleLoggingService } from './console-logging.service';
import { GetOptions } from '../models/get-options.model';
import { Observable, tap } from 'rxjs';
import { APIResponse } from '../models/api-response.model';
import { CONST } from '../shared/constants';

@Injectable({
  providedIn: 'root',
})
export class GenericApiService {
  constructor(
    private _http: HttpClient,
    private _logging: ConsoleLoggingService
  ) {}
  
  public getGenericService<T>(
    api: string, // endpoint
    opt?: GetOptions
  ): Observable<APIResponse<T>>{
    // Programmazione asincrona: non aspetto una risposta prima di inviare un altra richiesta
    return this._http
    .get<APIResponse<T>>(api, opt || CONST.defaultOptions)
    .pipe(
      tap((result) => this._logging.printLog(result))
    );
  }

}
