package it.betacom.GestionaleDipendenti.repository;

import it.betacom.GestionaleDipendenti.model.DipendenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends JpaRepository<DipendenteModel, Integer> {
}
