package it.betacom.GestionaleDipedenti.serviceImpl;

import it.betacom.GestionaleDipedenti.model.DipendenteModel;
import it.betacom.GestionaleDipedenti.repository.IDipendenteRepository;
import it.betacom.GestionaleDipedenti.service.IDipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DipendenteServiceImpl implements IDipendenteService {
    @Autowired
    private IDipendenteRepository repository;

    @Override
    public List<DipendenteModel> getAll() {
        return repository.findAll(Sort.by(Sort.Order.desc("cognome")));
    }

    @Override
    public DipendenteModel saveOrUpdate(DipendenteModel entity) {
        return repository.save(entity);
    }
}
