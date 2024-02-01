package it.betacom.GestionaleDipedenti.repository;

import it.betacom.GestionaleDipedenti.model.DipendenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDipendenteRepository extends JpaRepository<DipendenteModel, Integer> {

}
