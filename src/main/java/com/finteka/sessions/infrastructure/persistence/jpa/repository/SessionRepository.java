package com.finteka.sessions.infrastructure.persistence.jpa.repository;

import com.finteka.sessions.domain.entities.SessionEntity;
import com.finteka.sessions.domain.model.enums.SessionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<SessionEntity, Long> {

    List<SessionEntity> findByProfesionalIdAndFechaAfterAndEstado(Long profesionalId, LocalDateTime fecha, SessionStatus estado);

    Optional<SessionEntity> findByProfesionalIdAndFecha(Long profesionalId, LocalDateTime fecha);

}
