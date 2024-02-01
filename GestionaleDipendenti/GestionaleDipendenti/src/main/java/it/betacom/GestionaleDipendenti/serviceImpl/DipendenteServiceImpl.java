package it.betacom.GestionaleDipendenti.serviceImpl;

import it.betacom.GestionaleDipendenti.model.DipendenteModel;
import it.betacom.GestionaleDipendenti.repository.DipendenteRepository;
import it.betacom.GestionaleDipendenti.service.IDipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendenteServiceImpl implements IDipendenteService {

    @Autowired
    private DipendenteRepository repository;
    @Override
    public List<DipendenteModel> getAll() {
        return repository.findAll(Sort.by(Sort.Order.desc("cognome")));
    }

    @Override
    public DipendenteModel saveOrUpdate(DipendenteModel entity) {
        return repository.save(entity);
    }
}
