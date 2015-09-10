package com.invivoo.ficheprojet.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invivoo.ficheprojet.app.domain.Function;

public interface FunctionRepository extends JpaRepository<Function, Long> {

    Function findOneByName(String name);
}
