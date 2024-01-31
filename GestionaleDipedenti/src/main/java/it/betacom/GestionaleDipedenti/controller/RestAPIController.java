package it.betacom.GestionaleDipedenti.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/restAPI")
public class RestAPIController {
    @GetMapping(value="/getall")
    public String getSaluto(){
        return "Hello World!";
    }
    @PostMapping(value="/saveorupdate")
    public String getNome(@RequestParam String nome){
        return "Ciao " + nome;
    }
}
