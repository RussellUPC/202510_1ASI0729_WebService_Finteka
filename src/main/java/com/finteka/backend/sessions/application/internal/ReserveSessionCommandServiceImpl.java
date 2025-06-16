package com.finteka.backend.sessions.application.internal;

import com.finteka.backend.sessions.domain.model.Session;
import com.finteka.backend.sessions.domain.model.enums.SessionStatus;
import com.finteka.backend.sessions.domain.services.ReserveSessionCommandService;
import com.finteka.backend.sessions.infrastructure.persistence.jpa.entities.SessionEntity;
import com.finteka.backend.sessions.infrastructure.persistence.jpa.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReserveSessionCommandServiceImpl implements ReserveSessionCommandService {

    private final SessionRepository sessionRepository;

    public ReserveSessionCommandServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public Optional<Session> reserveSession(Long profesionalId, Long clienteId, LocalDateTime fecha) {
        Optional<SessionEntity> optionalEntity = sessionRepository
                .findByProfesionalIdAndFecha(profesionalId, fecha);

        if (optionalEntity.isEmpty()) {
            return Optional.empty();
        }

        SessionEntity entity = optionalEntity.get();
        entity.setEstado(SessionStatus.NOT_AVAILABLE);
        entity.setClienteId(clienteId);
        sessionRepository.save(entity);

        Session session = new Session(
                entity.getId(),
                entity.getProfesionalId(),
                entity.getClienteId(),
                entity.getFecha(),
                entity.getEstado()
        );

        return Optional.of(session);
    }
}
