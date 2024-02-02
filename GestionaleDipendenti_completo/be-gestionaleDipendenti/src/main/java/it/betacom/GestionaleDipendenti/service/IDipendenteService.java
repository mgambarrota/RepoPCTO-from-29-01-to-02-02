package it.betacom.GestionaleDipendenti.service;

import it.betacom.GestionaleDipendenti.model.DipendenteModel;

import java.util.List;

public interface IDipendenteService {
    List<DipendenteModel> getAll();

    DipendenteModel saveOrUpdate(DipendenteModel entity);
}
