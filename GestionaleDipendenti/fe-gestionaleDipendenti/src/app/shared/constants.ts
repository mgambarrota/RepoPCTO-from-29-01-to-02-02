import { HttpHeaders } from "@angular/common/http";
import { GetOptions } from "../models/get-options.model";

export class CONST{
  public static API_URL:string = "/public/gestionale";
  public static defaultOptions: GetOptions = {
    headers: new HttpHeaders().set('Content-Type', 'application/json')
  };

  public static ASSUNTO:string = "ASSUNTO";
  public static LICENZIATO:string = "LICENZIATO";

  public static SUCCESS:string = "success";
  public static DANGER:string = "danger";


  public static TIMES:string = "pi pi-times";
  public static CHECK:string = "pi pi-check";

}
