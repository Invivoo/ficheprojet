package com.invivoo.ficheprojet.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invivoo.ficheprojet.app.domain.FunctionType;

public interface FunctionTypeRepository extends JpaRepository<FunctionType, Long> {

    FunctionType findOneByName(String name);
}
