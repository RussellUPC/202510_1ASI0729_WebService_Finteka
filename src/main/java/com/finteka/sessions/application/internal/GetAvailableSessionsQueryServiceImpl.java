package com.finteka.sessions.application.internal;

import org.springframework.stereotype.Service;
import com.finteka.sessions.domain.model.Session;
import com.finteka.sessions.domain.model.enums.SessionStatus;
import com.finteka.sessions.domain.services.GetAvailableSessionsQueryService;
import com.finteka.sessions.domain.entities.SessionEntity;
import com.finteka.sessions.infrastructure.persistence.jpa.repository.SessionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAvailableSessionsQueryServiceImpl implements GetAvailableSessionsQueryService {

    private final SessionRepository sessionRepository;

    public GetAvailableSessionsQueryServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public List<Session> getAvailableSessions(Long profesionalId) {
        List<SessionEntity> sessionEntities = sessionRepository.findByProfesionalIdAndFechaAfterAndEstado(
                profesionalId,
                LocalDateTime.now(),
                SessionStatus.AVAILABLE
        );

        return sessionEntities.stream()
                .map(entity -> new Session(
                        entity.getId(),
                        entity.getProfesionalId(),
                        entity.getClienteId(),
                        entity.getFecha(),
                        entity.getEstado(),
                        entity.getDuracion()
                ))
                .collect(Collectors.toList());
    }
}
