import { HttpHeaders } from "@angular/common/http";
import { GetOptions } from "../models/get-options.model";

export class CONST{
    // API endpoint
    public static API_URL:string = "/public/gestionale";
    
    // Default HTTP options
    public static defaultOptions: GetOptions = {
        headers: new HttpHeaders().set("Content-Type", "application/json")
    };

    // Stato del dipendente
    public static ASSUNTO:string = "ASSUNTO";
    public static LICENZIATO:string = "LICENZIATO";

    // Colori
    public static SUCCESS:string = "success";
    public static DANGER:string = "danger";

    // Icone
    public static TIMES:string = "pi pi-times";
    public static CHECK:string = "pi pi-check";   
}