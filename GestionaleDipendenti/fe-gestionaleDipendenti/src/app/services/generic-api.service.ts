import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ConsoleLoggingService } from './console-logging.service';
import { GetOptions } from '../models/get-options.model';
import { Observable, catchError, tap } from 'rxjs';
import { ApiResponse } from '../models/api-response.model';
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
    api: string,
    opt?: GetOptions
  ): Observable<ApiResponse<T>> {
    return this._http
      .get<ApiResponse<T>>(api, opt || CONST.defaultOptions)
      .pipe(tap((result) => this._logging.printLog(result)));
  }

  public postGenericService<T>(
    obj: T,
    api: string,
    opt?: GetOptions
  ): Observable<ApiResponse<T>> {
    return this._http
      .post<ApiResponse<T>>(api, obj, opt || CONST.defaultOptions)
      .pipe(
        catchError((error) => {
          this._logging.printLog(error);
          throw Error();
        }),
        tap((result) => this._logging.printLog(result))
      );
  }
}
