package com.finteka.sessions.interfaces.rest;

import com.finteka.sessions.domain.model.Session;
import com.finteka.sessions.domain.services.CreateSessionCommandService;
import com.finteka.sessions.domain.services.GetAvailableSessionsQueryService;
import com.finteka.sessions.domain.services.ReserveSessionCommandService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/sessions")
@Validated
public class SessionResource {

    private final CreateSessionCommandService createSessionService;
    private final GetAvailableSessionsQueryService getAvailableSessionsService;
    private final ReserveSessionCommandService reserveSessionService;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public SessionResource(CreateSessionCommandService createSessionService,
                           GetAvailableSessionsQueryService getAvailableSessionsService,
                           ReserveSessionCommandService reserveSessionService) {
        this.createSessionService = createSessionService;
        this.getAvailableSessionsService = getAvailableSessionsService;
        this.reserveSessionService = reserveSessionService;
    }

    @PostMapping
    public ResponseEntity<Session> createSession(@RequestParam @NotNull Long profesionalId,
                                                 @RequestParam @NotNull Long clienteId,
                                                 @RequestParam @NotNull String fecha) {
        LocalDateTime dateTime = LocalDateTime.parse(fecha);
        Session createdSession = createSessionService.createSession(profesionalId, clienteId, dateTime);
        return ResponseEntity.ok(createdSession);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Session>> getAvailableSessions(@RequestParam @NotNull Long profesionalId) {
        List<Session> availableSessions = getAvailableSessionsService.getAvailableSessions(profesionalId);
        return ResponseEntity.ok(availableSessions);
    }

    @PostMapping("/reserve")
    public ResponseEntity<Session> reserveSession(@RequestParam @NotNull Long profesionalId,
                                                  @RequestParam @NotNull Long clienteId,
                                                  @RequestParam @NotNull String fecha) {
        LocalDateTime dateTime = LocalDateTime.parse(fecha);
        return reserveSessionService.reserveSession(profesionalId, clienteId, dateTime)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
