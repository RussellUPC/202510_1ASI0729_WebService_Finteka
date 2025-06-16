package com.finteka.backend.sessions.application.internal;

import org.springframework.stereotype.Service;
import com.finteka.backend.sessions.domain.model.Session;
import com.finteka.backend.sessions.domain.model.enums.SessionStatus;
import com.finteka.backend.sessions.domain.services.CreateSessionCommandService;
import com.finteka.backend.sessions.infrastructure.persistence.jpa.entities.SessionEntity;
import com.finteka.backend.sessions.infrastructure.persistence.jpa.repository.SessionRepository;

import java.time.LocalDateTime;

@Service
public class CreateSessionCommandServiceImpl implements CreateSessionCommandService {

    private final SessionRepository sessionRepository;

    public CreateSessionCommandServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public Session createSession(Long profesionalId, Long clienteId, LocalDateTime fecha) {
        SessionEntity entity = new SessionEntity();
        entity.setProfesionalId(profesionalId);
        entity.setClienteId(clienteId);
        entity.setFecha(fecha);
        entity.setEstado(SessionStatus.AVAILABLE);
        entity.setDuracion(30);
        SessionEntity savedEntity = sessionRepository.save(entity);

        return new Session(
                savedEntity.getId(),
                savedEntity.getProfesionalId(),
                savedEntity.getClienteId(),
                savedEntity.getFecha(),
                savedEntity.getEstado()
        );
    }
}
