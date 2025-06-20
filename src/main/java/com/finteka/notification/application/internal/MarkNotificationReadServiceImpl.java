package com.finteka.notification.application.internal;

import com.finteka.notification.domain.repository.NotificationRepository;
import com.finteka.notification.domain.service.MarkNotificationReadService;
import org.springframework.stereotype.Service;

@Service
public class MarkNotificationReadServiceImpl implements MarkNotificationReadService {
    private final NotificationRepository repository;
    public MarkNotificationReadServiceImpl(NotificationRepository repository) {
        this.repository = repository;
    }
    @Override
    public void execute(Long id) {
        repository.markAsRead(id);
    }
}