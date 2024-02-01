package it.betacom.GestionaleDipendenti.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ApiResponse <T>{
    private int codiceEsitoOperazione;
    private String descrizioneEsito;
    private int oggettiRestituiti;
    private int oggettiTotali;
    private T payload;
    @JsonInclude(Include.NON_NULL)
    private ApiError errori;
}
