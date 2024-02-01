package it.betacom.GestionaleDipedenti.config;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDetail {
    /*
        - Campi di errore;
        - Sorgente d'errore;
        - Codice dell'errore
        - Messaggio d'errore
     */
    private String field;
    private String source;
    private String code;
    private String message;

}
