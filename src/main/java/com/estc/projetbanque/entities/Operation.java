package com.estc.projetbanque.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OP", discriminatorType = DiscriminatorType.STRING, length = 1)
@Data @NoArgsConstructor @ToString
public abstract class Operation implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private Date dateOperation;
    private double montant;
    @ManyToOne
    @JoinColumn(name = "CODE_CPTE")
    private Compte compte;
    public Operation(Date dateOperation, double montant, Compte compte) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compte = compte;
    }
}
