package it.betacom.GestionaleDipedenti.service;

import it.betacom.GestionaleDipedenti.model.DipendenteModel;
import java.util.List;

public interface IDipendenteService {
    List <DipendenteModel> getAll();
    DipendenteModel saveOrUpdate(DipendenteModel entity);

}
