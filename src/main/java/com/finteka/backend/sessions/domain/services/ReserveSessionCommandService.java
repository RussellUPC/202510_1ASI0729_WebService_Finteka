package com.finteka.backend.sessions.domain.services;

import com.finteka.backend.sessions.domain.model.Session;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ReserveSessionCommandService {
    Optional<Session> reserveSession(Long profesionalId, Long clienteId, LocalDateTime fecha);
}
