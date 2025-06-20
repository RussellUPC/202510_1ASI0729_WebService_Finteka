package com.finteka.sessions.domain.services;

import com.finteka.sessions.domain.model.Session;

import java.time.LocalDateTime;

public interface CreateSessionCommandService {
    Session createSession(Long profesionalId, Long clienteId, LocalDateTime fecha);
}
