package com.estc.projetbanque.entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("CC")
@Getter @Setter @NoArgsConstructor @ToString
public class CompteCourant extends Compte{
    private double decouvert;

    public CompteCourant(String codeCompte, Date dateCreation, double solde, Client client, double decouvert) {
        super(codeCompte, dateCreation, solde, client);
        this.decouvert = decouvert;
    }
}
