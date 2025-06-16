package com.finteka.backend.sessions.domain.services;

import com.finteka.backend.sessions.domain.model.Session;

import java.util.List;

public interface GetAvailableSessionsQueryService {
    List<Session> getAvailableSessions(Long profesionalId);
}
