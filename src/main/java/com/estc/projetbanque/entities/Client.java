package com.estc.projetbanque.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @ToString
public class Client implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String nom;
    String email;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Collection<Compte> comptes;

    public Client(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }
}
