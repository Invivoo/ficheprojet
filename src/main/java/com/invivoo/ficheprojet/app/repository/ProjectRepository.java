package com.invivoo.ficheprojet.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invivoo.ficheprojet.app.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findOneByName(String name);
}
