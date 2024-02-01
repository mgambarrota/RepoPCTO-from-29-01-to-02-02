package it.betacom.GestionaleDipedenti.config;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse <T>{
    /*
        - status code
        - descrizione
        - quantità di oggetti ricevuti
        - quantità di oggetti totali
        - payload
     */
    private int codiceEsitoOperazione;
    private String descrizioneEsitoOperazione;
    private int oggettiRestituiti;
    private int oggettiTotaliRestituiti;
    private T payload;
    private APIError errori;

}

