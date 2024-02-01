package it.betacom.GestionaleDipedenti.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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

    @JsonInclude(Include.NON_NULL)
    private APIError errori;
}

