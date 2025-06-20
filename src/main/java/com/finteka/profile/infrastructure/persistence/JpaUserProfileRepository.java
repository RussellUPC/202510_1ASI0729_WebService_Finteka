package com.finteka.profile.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finteka.profile.infrastructure.persistence.models.UserProfileEntity;

@Repository
public interface JpaUserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
    // Métodos personalizados si los necesitas
}