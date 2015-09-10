package com.invivoo.ficheprojet.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invivoo.ficheprojet.app.domain.MissionType;

public interface MissionTypeRepository extends JpaRepository<MissionType, Long> {

    MissionType findOneByName(String name);
}
