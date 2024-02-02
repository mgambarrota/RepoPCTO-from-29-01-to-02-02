import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})

export class ConsoleLoggingService {
  constructor() {}

  printLog(logMsg: Object) {
    console.log(logMsg);
  }
}