import { HttpHeaders, HttpParams } from "@angular/common/http";

export interface GetOptions {
    headers?: HttpHeaders;
    body?: any;
    observe?: "body" | undefined;
    params?: HttpParams | { [param: string]: string | string[]; } | undefined;
    reportProgress?: boolean | undefined;
    withCredentials?: boolean | undefined;
}
