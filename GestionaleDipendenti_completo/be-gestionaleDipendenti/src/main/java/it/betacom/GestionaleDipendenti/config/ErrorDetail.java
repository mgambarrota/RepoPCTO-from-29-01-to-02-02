package it.betacom.GestionaleDipendenti.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDetail {
    private String field;
    private String source;
    private String code;
    private String message;
}
