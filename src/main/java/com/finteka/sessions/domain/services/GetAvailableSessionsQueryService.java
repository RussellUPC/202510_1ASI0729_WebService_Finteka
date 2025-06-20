package com.finteka.sessions.domain.services;

import com.finteka.sessions.domain.model.Session;

import java.util.List;

public interface GetAvailableSessionsQueryService {
    List<Session> getAvailableSessions(Long profesionalId);
}
