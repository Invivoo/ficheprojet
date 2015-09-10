package com.invivoo.ficheprojet.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invivoo.ficheprojet.app.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Mission findOneByTitle(String title);
}
