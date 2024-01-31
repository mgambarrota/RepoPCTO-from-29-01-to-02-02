package it.marconi.GestionaleDipendenti.service;

import it.marconi.GestionaleDipendenti.model.DipendenteModel;

import java.util.List;

public interface IDipendenteService {
    List<DipendenteModel> getAll();

    DipendenteModel saveOrUpdate(DipendenteModel entity);
}
