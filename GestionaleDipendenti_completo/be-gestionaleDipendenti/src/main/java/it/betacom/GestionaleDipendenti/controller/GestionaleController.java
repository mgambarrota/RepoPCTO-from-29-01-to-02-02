package it.betacom.GestionaleDipendenti.controller;

import it.betacom.GestionaleDipendenti.config.ApiError;
import it.betacom.GestionaleDipendenti.config.ApiResponse;
import it.betacom.GestionaleDipendenti.config.ErrorDetail;
import it.betacom.GestionaleDipendenti.model.DipendenteModel;
import it.betacom.GestionaleDipendenti.service.IDipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = {"/public/gestionale"})
public class GestionaleController {

    @Autowired
    private IDipendenteService dipendenteService;

    @GetMapping(value = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ApiResponse<List<DipendenteModel>>> getAll(){
        ApiResponse.ApiResponseBuilder<List<DipendenteModel>> builder = ApiResponse.builder();
        try{
            List<DipendenteModel> dipendenti = dipendenteService.getAll();
            if(!dipendenti.isEmpty()){
                builder
                        .descrizioneEsitoOperazione("Lista dei dipendenti recuperata correttamente")
                        .codiceEsitoOperazione(HttpStatus.OK.value())
                        .oggettiRestituiti(dipendenti.size())
                        .oggettiTotali(dipendenti.size())
                        .payload(dipendenti);
            }else{
                builder
                        .descrizioneEsitoOperazione("Lista dei dipendenti vuota")
                        .codiceEsitoOperazione(HttpStatus.OK.value())
                        .oggettiTotali(0)
                        .oggettiRestituiti(0);
            }
            ApiResponse<List<DipendenteModel>> result = builder.build();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.<List<DipendenteModel>>builder()
                            .codiceEsitoOperazione(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .descrizioneEsitoOperazione("Errore durante il recupero della lista dei dipendenti")
                            .oggettiRestituiti(0)
                            .oggettiTotali(0)
                            .errori(ApiError.builder()
                                    .details(Collections.singletonList(
                                                    ErrorDetail.builder()
                                                            .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                                                            .field("generico")
                                                            .source("repository.findAll()")
                                                            .message(e.getMessage()).build()))
                                    .path("/public/gestionale/getAll")
                                    .timestamp(new Date())
                                    .build()
                            ).build());
        }
    }

    @PostMapping(value = "/insert", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ApiResponse<DipendenteModel>> save(@RequestBody @Validated DipendenteModel model){
        try{
            DipendenteModel result = dipendenteService.saveOrUpdate(model);
            return ResponseEntity.status(HttpStatus.OK).body(
                    ApiResponse.<DipendenteModel>builder()
                            .codiceEsitoOperazione(HttpStatus.OK.value())
                            .descrizioneEsitoOperazione("Inserimento del dipendente andato a buon fine")
                            .oggettiRestituiti(1)
                            .oggettiTotali(1)
                            .payload(result).build()
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    ApiResponse.<DipendenteModel>builder()
                            .codiceEsitoOperazione(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .descrizioneEsitoOperazione("Errore nell'inserimento del dipendente")
                            .oggettiRestituiti(0)
                            .oggettiTotali(0)
                            .errori(
                                    ApiError.builder()
                                            .timestamp(new Date())
                                            .path("/insert")
                                            .details(
                                                    Collections.singletonList(
                                                            ErrorDetail.builder()
                                                                    .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                                                                    .field("generico")
                                                                    .source("repository.save()")
                                                                    .message(e.getMessage()).build()
                                                    )
                                            ).build()
                            ).build()
            );
        }
    }
}
