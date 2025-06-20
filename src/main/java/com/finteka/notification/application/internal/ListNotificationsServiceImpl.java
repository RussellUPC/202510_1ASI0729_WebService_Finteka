package com.finteka.notification.application.internal;

import com.finteka.notification.domain.entity.Notification;
import com.finteka.notification.domain.repository.NotificationRepository;
import java.util.List;

import com.finteka.notification.domain.service.ListNotificationsService;
import org.springframework.stereotype.Service;

@Service
public class ListNotificationsServiceImpl implements ListNotificationsService {
    private final NotificationRepository repository;
    public ListNotificationsServiceImpl(NotificationRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<Notification> execute(Long profesionalId) {
        return repository.findByProfesionalId(profesionalId);
    }
}
