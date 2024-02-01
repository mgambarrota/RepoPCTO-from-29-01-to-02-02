package it.betacom.GestionaleDipedenti.controller;


import it.betacom.GestionaleDipedenti.config.APIError;
import it.betacom.GestionaleDipedenti.config.APIResponse;
import it.betacom.GestionaleDipedenti.config.ErrorDetail;
import it.betacom.GestionaleDipedenti.model.DipendenteModel;
import it.betacom.GestionaleDipedenti.repository.IDipendenteRepository;
import it.betacom.GestionaleDipedenti.service.IDipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.html.HTMLParagraphElement;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = {"/public/gestionale"})
public class GestionaleController {
    @Autowired
    private IDipendenteService dipendenteService;

    @GetMapping(value = {"/getall"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<APIResponse<List<DipendenteModel>>> getAll(){
        APIResponse.APIResponseBuilder<List<DipendenteModel>> builder = APIResponse.builder();
        try{
            List<DipendenteModel> dipendenti = dipendenteService.getAll();
            if(!dipendenti.isEmpty()){
                builder
                        .descrizioneEsitoOperazione("Lista dei dipendenti" +
                                                    "recuperata correttamente")
                        .codiceEsitoOperazione(HttpStatus.OK.value())
                        .oggettiRestituiti(dipendenti.size())
                        .oggettiTotaliRestituiti(dipendenti.size())
                        .payload(dipendenti);
            }else{
                builder
                        .descrizioneEsitoOperazione("Lista dei dipendneti vuota")
                        .codiceEsitoOperazione(HttpStatus.OK.value())
                        .oggettiRestituiti(0)
                        .oggettiTotaliRestituiti(0);
            }

            // Creazione dell'oggetto
            APIResponse<List<DipendenteModel>> result = builder.build();

            return ResponseEntity.status(HttpStatus.OK).body(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    APIResponse.<List<DipendenteModel>>builder()

                            .codiceEsitoOperazione(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .descrizioneEsitoOperazione("Errore durante il recupero della " +
                                    "lista dei dipendneti")
                            .oggettiRestituiti(0)
                            .oggettiTotaliRestituiti(0)
                            .errori(
                                    APIError.builder()
                                            .timestamp(new Date())
                                            .details(
                                                    Collections.singletonList(
                                                            ErrorDetail.builder()
                                                                    .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                                                                    .field("generico")
                                                                    .source("repository.findAll()")
                                                                    .message(e.getMessage()).build()
                                                    )
                                            )
                                            .path("/public/gestioanle/getall").build()

                            ).build()
            );
        }

    }

     @PostMapping(value = "/insert",
             consumes = {MediaType.APPLICATION_JSON_VALUE},
             produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<APIResponse<DipendenteModel>> save(@RequestBody @Validated DipendenteModel model){
        try{
            DipendenteModel result = dipendenteService.saveOrUpdate(model);

            return ResponseEntity.status(HttpStatus.OK).body(
                    APIResponse.<DipendenteModel>builder()
                            .codiceEsitoOperazione(HttpStatus.OK.value())
                            .descrizioneEsitoOperazione("Inserimento del dipendente andato a buon fine")
                            .oggettiRestituiti(1)
                            .oggettiTotaliRestituiti(1)
                            .payload(result).build());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    APIResponse.<DipendenteModel>builder()
                            .codiceEsitoOperazione(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .descrizioneEsitoOperazione("Errore nell'inserimento del dipendente")
                            .oggettiRestituiti(0)
                            .oggettiTotaliRestituiti(0)
                            .errori(
                                    APIError.builder()
                                            .timestamp(new Date())
                                            .path("/public/gestionale/insert")
                                            .details(
                                                    Collections.singletonList(
                                                            ErrorDetail.builder()
                                                                    .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                                                                    .field("generico")
                                                                    .source("repository.saveOrUpdate()")
                                                                    .message(e.getMessage()).build()
                                                    )
                                            ).build()
                            ).build()
            );

        }
    }
}
