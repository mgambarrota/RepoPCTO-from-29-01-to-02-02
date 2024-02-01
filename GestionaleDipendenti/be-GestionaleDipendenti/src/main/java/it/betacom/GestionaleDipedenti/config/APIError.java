package it.betacom.GestionaleDipedenti.config;

import lombok.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class APIError {
    /*
        - Data errore -> ISO 8601;
        - Dov'è l'errore
        - Lista degli errori;
     */
    @Builder.Default
    private Date timestamp = new Date();
    private String path;
    private List<ErrorDetail> details;
}
