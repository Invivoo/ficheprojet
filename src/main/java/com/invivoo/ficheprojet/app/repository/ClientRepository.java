package com.invivoo.ficheprojet.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invivoo.ficheprojet.app.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findOneByAccount(String account);
}
