package com.finteka.notification.interfaces.rest;

import com.finteka.notification.domain.service.CreateNotificationService;
import com.finteka.notification.domain.service.ListNotificationsService;
import com.finteka.notification.domain.service.MarkNotificationReadService;
import com.finteka.notification.interfaces.rest.dto.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/notificaciones",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class NotificationResource {

    private final ListNotificationsService listNotificationsService;
    private final CreateNotificationService createNotificationService;
    private final MarkNotificationReadService markNotificationReadService;

    public NotificationResource(ListNotificationsService listNotificationsService,
                                CreateNotificationService createNotificationService,
                                MarkNotificationReadService markNotificationReadService) {
        this.listNotificationsService = listNotificationsService;
        this.createNotificationService = createNotificationService;
        this.markNotificationReadService = markNotificationReadService;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NotificationDTO> list(@RequestParam Long profesionalId) {
        return listNotificationsService.execute(profesionalId)
                .stream()
                .map(NotificationDTO::fromDomain)
                .collect(Collectors.toList());
    }

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public NotificationDTO create(@RequestBody CreateNotificationDTO dto) {
        return NotificationDTO.fromDomain(
                createNotificationService.execute(dto.toDomain())
        );
    }

    @PostMapping(path = "/{id}/read", produces = MediaType.APPLICATION_JSON_VALUE)
    public void markRead(@PathVariable Long id) {
        markNotificationReadService.execute(id);
    }
}