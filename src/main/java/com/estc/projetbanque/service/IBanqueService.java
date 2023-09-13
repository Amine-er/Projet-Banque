package com.estc.projetbanque.service;

import com.estc.projetbanque.entities.Compte;
import com.estc.projetbanque.entities.Operation;
import org.springframework.data.domain.Page;

public interface IBanqueService {
    public Compte consulterCompte(String codeCpte);
    public void verser(String codeCpte, double montant);
    public void retirer(String codeCpte, double montant);
    public void virement(String codeCpte1, String codeCpte2, double monatnt);
    public Page<Operation> listOperation(String codeCpte, int page, int size);
}
