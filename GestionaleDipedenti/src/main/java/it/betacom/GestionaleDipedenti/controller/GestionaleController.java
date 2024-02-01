package it.betacom.GestionaleDipedenti.controller;


import it.betacom.GestionaleDipedenti.config.APIResponse;
import it.betacom.GestionaleDipedenti.model.DipendenteModel;
import it.betacom.GestionaleDipedenti.repository.IDipendenteRepository;
import it.betacom.GestionaleDipedenti.service.IDipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/public/gestionale"})
public class GestionaleController {
    @Autowired
    private IDipendenteService dipendenteService;

    @GetMapping(value = {"/getall"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<APIResponse<List<DipendenteModel>>> getAll(){
        
    }
}
