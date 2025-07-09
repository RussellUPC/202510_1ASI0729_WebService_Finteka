package com.finteka.profile.infrastructure.persistence.repositories;

import com.finteka.profile.infrastructure.persistence.models.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    // Custom queries if needed
}

