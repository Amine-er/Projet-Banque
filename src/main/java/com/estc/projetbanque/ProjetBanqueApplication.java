package com.estc.projetbanque;

import com.estc.projetbanque.dao.ClientRepository;
import com.estc.projetbanque.dao.CompteRepository;
import com.estc.projetbanque.dao.OperationRepository;
import com.estc.projetbanque.entities.*;
import com.estc.projetbanque.service.IBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ProjetBanqueApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private IBanqueService banqueService;

    public static void main(String[] args) {
        SpringApplication.run(ProjetBanqueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Client c1 = clientRepository.save(new Client("Amine","amine@gmail.com"));
        Client c2 = clientRepository.save(new Client("Ayoub","ayoub@gmail.com"));

        Compte cp1 = compteRepository.save(new CompteCourant("c1", new Date(),90000,c1,6000));
        Compte cp2 = compteRepository.save(new CompteCourant("c2", new Date(),50000,c1,3500));
        Compte cp3 = compteRepository.save(new CompteEpargne("c3", new Date(), 7000, c2, 3.5));

        /*operationRepository.save(new Versement(new Date(),9000,cp1));
        operationRepository.save(new Versement(new Date(),5000,cp1));
        operationRepository.save(new Retrait(new Date(),4000,cp1));

        operationRepository.save(new Versement(new Date(),9000,cp2));
        operationRepository.save(new Versement(new Date(),9000,cp2));
        operationRepository.save(new Retrait(new Date(),9000,cp2));

        operationRepository.save(new Versement(new Date(),9000,cp3));
        operationRepository.save(new Versement(new Date(),9000,cp3));
        operationRepository.save(new Retrait(new Date(),9000,cp3));*/

        banqueService.verser("c1", 10000);
        banqueService.verser("c2", 10000);
        banqueService.verser("c3", 10000);

        banqueService.retirer("c1", 50000);
        banqueService.retirer("c2", 20000);
        banqueService.retirer("c3", 6000);

        banqueService.virement("c1","c2",20000);

        //System.out.println(banqueService.consulterCompte("c1"));
        //System.out.println(banqueService.consulterCompte("c4"));


    }
}
