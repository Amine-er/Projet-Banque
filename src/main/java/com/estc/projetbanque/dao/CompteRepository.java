package com.estc.projetbanque.dao;

import com.estc.projetbanque.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, String> {
    public Compte findByCodeCompte(String codeCpte);
}
