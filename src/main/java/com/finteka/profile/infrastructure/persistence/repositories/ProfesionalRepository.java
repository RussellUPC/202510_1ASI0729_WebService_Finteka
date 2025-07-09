package com.finteka.profile.infrastructure.persistence.repositories;

import com.finteka.profile.infrastructure.persistence.models.ProfesionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesionalRepository extends JpaRepository<ProfesionalEntity, Long> {
    // Custom queries if needed
}

