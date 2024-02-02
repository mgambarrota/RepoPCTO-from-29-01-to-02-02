import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GetOptions } from '../models/get-options.model';
import { Observable, catchError, tap } from 'rxjs';
import { CONST } from '../shared/constants';
import { ApiResponse } from '../models/api-response.model';
import { ConsoleLoggingService } from './console-logging.service';

@Injectable({
  providedIn: 'root',
})
export class GenericApiService {
  constructor(private http: HttpClient,
    private log: ConsoleLoggingService
    ) {}

  public postGenericService<T, S>(
    postObj: T,
    api: string,
    opt?: GetOptions
  ): Observable<ApiResponse<S>> {
    return this.http
      .post<ApiResponse<S>>(api, postObj, opt || CONST.defaultOptions)
      .pipe(
        catchError((error) => {
          throw Error();
        }),
        tap((res) => {
          this.log.printLog(res);
        })
      );
  }

  public getGenericService<S>(
    api: string,
    opt?: GetOptions,
  ): Observable<ApiResponse<S>> {
    return this.http.get<ApiResponse<S>>(api, opt || CONST.defaultOptions).pipe(
      tap((res) => {
        this.log.printLog(res);
      })
    );
  }
}
