package it.marconi.GestionaleDipendenti.repository;

import it.marconi.GestionaleDipendenti.model.DipendenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends JpaRepository<DipendenteModel, Integer> {
}
