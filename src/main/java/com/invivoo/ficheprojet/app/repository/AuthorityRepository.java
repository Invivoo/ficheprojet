package com.invivoo.ficheprojet.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invivoo.ficheprojet.app.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findOneByName(String name);
}
