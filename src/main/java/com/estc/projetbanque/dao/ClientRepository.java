package com.estc.projetbanque.dao;

import com.estc.projetbanque.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
