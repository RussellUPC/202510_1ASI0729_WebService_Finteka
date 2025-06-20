package com.finteka.notification.application.internal;

import com.finteka.notification.domain.entity.Notification;
import com.finteka.notification.domain.repository.NotificationRepository;
import com.finteka.notification.domain.service.CreateNotificationService;
import org.springframework.stereotype.Service;

@Service
public class CreateNotificationServiceImpl implements CreateNotificationService {
    private final NotificationRepository repository;
    public CreateNotificationServiceImpl(NotificationRepository repository) {
        this.repository = repository;
    }
    @Override
    public Notification execute(Notification notification) {
        notification.setLeida(false);
        return repository.save(notification);
    }
}